package external.connection;

import common.core.message.MessageHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.concurrent.Future;

/**
 * WARNING: This class must have public visibility. It is otherwise not possible to obtain a session object after the
 * client connects!
 */
@SuppressWarnings("WeakerAccess")
@WebSocket(maxTextMessageSize = 1048576, maxBinaryMessageSize = 1048576)
// TODO: make the max message size limit more robust
public class JettySocket implements Socket<String> {

    private static final Logger LOG = LogManager.getLogger(JettySocket.class);

    private final WebSocketClient client;

    private MessageHandler<String> handler;
    private Session session;

    JettySocket() {
        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setTrustAll(true);

        client = new WebSocketClient(sslContextFactory);
    }

    @Override
    public void registerHandler(MessageHandler<String> handler) {
        this.handler = handler;
        LOG.debug("Registered new handler for socket");
    }

    @Override
    public void open(String endpoint) throws IllegalStateException {
        if (handler == null) {
            throw new IllegalStateException("No handler registered. Will not connect socket!");
        }

        try {
            client.start();
            Future<Session> fut = client.connect(this, URI.create(endpoint));
            session = fut.get();
        } catch (Throwable t) {
            LOG.error("Encountered error while opening the connection: {}", t);
        }
    }

    @Override
    public void close() {
        try {
            client.stop();
        } catch (Exception e) {
            LOG.error("Encountered error while closing the connection: {}", e);
        }
    }

    @Override
    public void send(String message) {
        try {
            session.getRemote().sendString(message);
        } catch (Exception e) {
            LOG.error("Encountered exception. Unable to send message \"{}\" due to exception {}", message, e);
        }
    }

    @SuppressWarnings("unused")
    @OnWebSocketConnect
    public void onConnect(Session sess) {
        LOG.info("Session connected");
    }

    @SuppressWarnings("unused")
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        LOG.info("Socket closing. code={}, reason={})", statusCode, reason);
    }

    @SuppressWarnings("unused")
    @OnWebSocketError
    public void onError(Throwable cause) {
        LOG.error("Socket encountered an error {}", cause);
    }

    @SuppressWarnings("unused")
    @OnWebSocketMessage
    public void onMessage(String message) {
        handler.handle(message);
    }
}