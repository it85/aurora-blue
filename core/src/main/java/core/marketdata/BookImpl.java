package core.marketdata;

import com.google.inject.Inject;
import common.app.marketdata.HalfBook;
import common.app.marketdata.MutableBook;
import common.app.marketdata.MutableHalfBook;

import java.nio.ByteBuffer;

final class BookImpl implements MutableBook {

    private final MutableHalfBook bids;
    private final MutableHalfBook asks;

    @Inject
    BookImpl(MutableHalfBook bids, MutableHalfBook asks) {
        this.bids = bids;
        this.asks = asks;
    }

    @Override
    public HalfBook bids() {
        return bids;
    }

    @Override
    public HalfBook asks() {
        return asks;
    }

    @Override
    public void clear() {
        bids.clear();
        asks.clear();
    }

    @Override
    public ByteBuffer serialize() {
        return null;
    }

    @Override
    public void deserialize(MutableBook target) {

    }

    @Override
    public MutableHalfBook mutableBids() {
        return bids;
    }

    @Override
    public MutableHalfBook mutableAsks() {
        return asks;
    }

    @Override
    public void copyBids(MutableHalfBook book) {

    }

    @Override
    public void copyAsks(MutableHalfBook book) {

    }
}
