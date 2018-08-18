package core.connection;

import common.connection.socket.Socket;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class JettySocketTest {

    private Socket<String> socket;

    @Before
    public void setUp() {
        socket = new JettySocket();
    }

    /**
     * If no handler is registered with the socket, an {@link IllegalStateException} is thrown
     */
    @Test(expected = IllegalStateException.class)
    public void nullHandlerExceptionTest() {
        socket.open(Mockito.anyString());
    }
}
