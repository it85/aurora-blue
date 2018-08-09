package common.transport.read;

import com.google.inject.Singleton;

public final class MarketDataTransportModule extends TransportReaderModule {

    @Override
    public void configure() {
        super.configure();

        bind(WireDataHandler.class).to(MarketDataWireHandler.class).in(Singleton.class);
    }
}
