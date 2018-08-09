package common.transport.read;

import com.google.inject.Singleton;
import external.ipc.IpcReaderModule;
import external.ipc.WireDataHandler;

public final class MarketDataReaderTransportModule extends TransportReaderModule {

    @Override
    public void configure() {
        super.configure();

        install(new IpcReaderModule());
        bind(WireDataHandler.class).to(MarketDataWireHandler.class).in(Singleton.class);
    }
}
