package app.marketdata;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import common.connection.socket.ConnectionModule;
import external.collection.FastCollectionSingletonModule;
import external.connection.ExternalSocketModule;
import external.ipc.IpcWriterModule;
import external.marketdata.MDSourceProvider;
import external.marketdata.MarketDataSourceModule;

public class MDSModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new MarketDataSourceModule());
        install(new IpcWriterModule());
        install(new ConnectionModule());
        install(new ExternalSocketModule());
        install(new FastCollectionSingletonModule());

        bind(new TypeLiteral<MDSourceProvider>() {
        }).in(Singleton.class);

        bind(MDChannelFactory.class).in(Singleton.class);
        bind(MDService.class).in(Singleton.class);
        bind(MDS.class).in(Singleton.class);
    }
}
