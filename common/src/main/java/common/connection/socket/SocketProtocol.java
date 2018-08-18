package common.connection.socket;

/**
 * Encapsulates connection details to a particular endpoint. Every SocketProtocol supplies it's connection URI {@link #endpoint()}
 * as well as the required initial sessionHandshake message {@link #sessionHandshake()}. This sessionHandshake message
 * is used to initiate a data streaming session.
 * <p>
 * !! This class requires the client to bind to a concrete implementation. The Network module is NOT responsible for
 * providing a concrete.
 */
public interface SocketProtocol {

    String endpoint();

    String sessionHandshake();

}
