package common.connection.socket;

import com.google.inject.Inject;
import common.transport.messaging.MessageHandler;

/**
 * Manipulates socket connections and is responsible for bringing up/shutting down sessions. This particular implementation
 * will handle messages of type String and requires the client to pass in a handler instance as well as a valid socket
 * endpoint.
 */
public final class SocketManager {

    private final Socket<String> socket;

    private SocketProtocol protocol;

    @Inject
    SocketManager(Socket<String> socket) {
        this.socket = socket;
    }

    public void init(MessageHandler<String> handler, SocketProtocol protocol) {
        this.socket.registerHandler(handler);
        this.protocol = protocol;
    }

    /**
     * Initiates a new session to the {@link #protocol}
     */
    public void begin() {
        socket.open(protocol.endpoint());
        socket.send(protocol.sessionHandshake());
    }

    /**
     * Shutdown the {@link #socket}
     */
    public void shutdown() {
        socket.close();
    }
}
