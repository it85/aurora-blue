package common.connection.socket;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import common.core.message.MessageHandler;
import external.connection.Socket;

/**
 * Manipulates socket connections and is responsible for bringing up/shutting down sessions. This particular implementation
 * will handle messages of type String and requires the client to pass in a handler instance as well as a valid socket
 * endpoint.
 */
public final class SocketManager {

    private final Socket<String> socket;
    private final SocketProtocol protocol;

    @Inject
    public SocketManager(Socket<String> socket,
                         @Assisted MessageHandler<String> handler,
                         @Assisted SocketProtocol protocol) {
        this.socket = socket;
        this.protocol = protocol;
        this.socket.registerHandler(handler);
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
