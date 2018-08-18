package core.marketdata;

import com.google.inject.Inject;
import common.app.marketdata.MDSource;
import common.app.marketdata.MarketDataType;
import common.transport.messaging.MessagingFactory;

public final class MDSourceProvider {

    private final MessagingFactory factory;
    private final MutableBookProvider bookProvider;

    @Inject
    MDSourceProvider(MessagingFactory factory, MutableBookProvider bookProvider) {
        this.factory = factory;
        this.bookProvider = bookProvider;
    }

    public final MDSource create(MarketDataType type) {
        switch (type) {
            case L1:
                throw new UnsupportedOperationException();
            case L2:
                return new L2Gdax(factory, bookProvider.get());
            case L3:
                return new L3Gdax(factory);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
