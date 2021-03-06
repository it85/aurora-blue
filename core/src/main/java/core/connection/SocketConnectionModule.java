package core.connection;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import common.connection.socket.ConnectionModule;
import common.connection.socket.Socket;

public class SocketConnectionModule extends AbstractModule {

    @Override
    public void configure() {
        install(new ConnectionModule());

        bind(new TypeLiteral<Socket<String>>() {
        }).to(new TypeLiteral<JettySocket>() {
        });
    }
}
