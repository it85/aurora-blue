package app.marketdata;

import com.google.inject.Inject;
import common.connection.socket.SocketManager;
import common.collection.FastQueue;
import common.transport.messaging.Message;
import common.app.marketdata.MarketDataType;
import external.marketdata.MDSourceProvider;

import static common.app.marketdata.MarketDataType.L2;
import static common.app.marketdata.MarketDataType.L3;

final class MDChannelFactory {

    private final FastQueue<Message> queue;
    private final SocketManager socketManager;
    private final MDSourceProvider sourceProvider;

    @Inject
    MDChannelFactory(FastQueue<Message> queue, SocketManager socketManager, MDSourceProvider sourceProvider) {
        this.queue = queue;
        this.socketManager = socketManager;
        this.sourceProvider = sourceProvider;
    }

    final MDChannel create(MarketDataType type) {
        switch (type) {
            case L1:
                throw new UnsupportedOperationException();
            case L2:
                return new MDChannel(socketManager, queue, sourceProvider.create(L2));
            case L3:
                return new MDChannel(socketManager, queue, sourceProvider.create(L3));
            default:
                throw new UnsupportedOperationException();
        }
    }
}