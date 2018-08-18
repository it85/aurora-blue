package common.connection.socket;

import common.transport.messaging.MessageHandler;

/**
 * A web socket used to open a TCP connection with an endpoint and handles messages of type T.
 */
public interface Socket<T> {

    void registerHandler(MessageHandler<T> handler);

    /**
     * Open a connection to the specified endpoint.
     *
     * @throws IllegalStateException re-open an existing connection
     * @throws IllegalStateException open without first registering a handler
     */
    void open(String endpoint) throws IllegalStateException;

    /**
     * Close this socket
     */
    void close();

    /**
     * Send a message to the socket endpoint
     */
    void send(String message);

}
