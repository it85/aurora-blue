package common.connection.socket;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import external.connection.ExternalSocketModule;

public final class ConnectionModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ExternalSocketModule());
        install(new FactoryModuleBuilder()
                .implement(SocketManager.class, SocketManager.class)
                .build(SocketManagerFactory.class));
    }
}
