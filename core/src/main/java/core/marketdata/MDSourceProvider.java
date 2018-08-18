package core.marketdata;

import com.google.inject.Inject;
import common.transport.messaging.MessagingFactory;
import common.app.marketdata.MDSource;
import common.app.marketdata.MarketDataType;

public final class MDSourceProvider {

    private final MessagingFactory factory;

    @Inject
    MDSourceProvider(MessagingFactory factory) {
        this.factory = factory;
    }

    public final MDSource create(MarketDataType type) {
        switch (type) {
            case L1:
                throw new UnsupportedOperationException();
            case L2:
                return new L2Gdax(factory);
            case L3:
                return new L3Gdax(factory);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
