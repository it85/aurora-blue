package common.network;

import com.google.inject.Guice;
import com.google.inject.Injector;
import common.message.MessageHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class NetworkGuiceTest {

    @Before
    public void setUp() {

    }

    @SuppressWarnings("unchecked")
    @Test
    public void factoryPatternTest() {
        Injector injector = Guice.createInjector(new NetworkModule());

        SocketManagerFactory factory = injector.getInstance(SocketManagerFactory.class);
        factory.create(Mockito.mock(MessageHandler.class), Mockito.mock(SocketProtocol.class));
    }
}
