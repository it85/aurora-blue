package core.connection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import common.connection.socket.ConnectionModule;
import common.connection.socket.Socket;
import common.connection.socket.SocketManagerFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Validates a variety of Guice-related behaviors
 */
public class NetworkGuiceTest {

    private Injector injector;

    @Before
    public void setUp() {
        injector = Guice.createInjector(new ConnectionModule());
    }

    /**
     * Assert that Guice is creating a singleton instance of {@link SocketManagerFactory} where ever we require injection
     */
    @Test
    public void socketManagerFactorySingletonTest() {
        SocketManagerFactory factory = injector.getInstance(SocketManagerFactory.class);
        SocketManagerFactory factory2 = injector.getInstance(SocketManagerFactory.class);

        assertSame(factory, factory2);
    }

    /**
     * Assert that we're able to get Guice to provide multiple unique instances of {@link Socket <String>}
     */
    @Test
    public void socketInjectionTest() {
        Socket<String> socket = injector.getInstance(Key.get(new TypeLiteral<Socket<String>>() {
        }));

        Socket<String> socket2 = injector.getInstance(Key.get(new TypeLiteral<Socket<String>>() {
        }));

        assertTrue(socket instanceof JettySocket);
        assertNotSame(socket, socket2);
    }
}
