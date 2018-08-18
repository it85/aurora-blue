package app.marketdata;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import common.connection.socket.ConnectionModule;
import core.collection.queue.FastQueueModule;
import core.connection.SocketConnectionModule;
import core.ipc.IpcWriterModule;
import core.marketdata.MDSourceProvider;
import core.marketdata.MarketDataSourceModule;

public class MDSModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new MarketDataSourceModule());
        install(new IpcWriterModule());
        install(new ConnectionModule());
        install(new SocketConnectionModule());
        install(new FastQueueModule());

        bind(new TypeLiteral<MDSourceProvider>() {
        }).in(Singleton.class);

        bind(MDChannelFactory.class).in(Singleton.class);
        bind(MDService.class).in(Singleton.class);
        bind(MDS.class).in(Singleton.class);
    }
}
