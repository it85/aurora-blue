package common.network;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public final class NetworkModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(SocketManager.class, SocketManager.class)
                .build(SocketManagerFactory.class));

        bind(Socket.class).to(JettySocket.class);
    }
}
