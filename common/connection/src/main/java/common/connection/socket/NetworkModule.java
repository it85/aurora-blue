package common.connection.socket;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public final class NetworkModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<Socket<String>>() {
        }).to(new TypeLiteral<JettySocket>() {
        });

        install(new FactoryModuleBuilder()
                .implement(SocketManager.class, SocketManager.class)
                .build(SocketManagerFactory.class));
    }
}
