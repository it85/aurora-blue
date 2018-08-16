package common.transport.read;

import com.google.inject.Inject;
import common.core.message.Message;

final class MarketDataWireHandler implements WireDataHandler {

    private final MarketDataEventDispatcher dispatcher;

    @Inject
    MarketDataWireHandler(MarketDataEventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void handle(Message message) {
        final short id = message.header().id();

        switch (id) {
            case 1:
                break;
            default:

        }
    }
}
