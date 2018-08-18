package external.marketdata;

import common.app.marketdata.Book;
import common.app.marketdata.HalfBook;

import java.nio.ByteBuffer;

final class BookImpl implements Book {

    private final HalfBookImpl bids;
    private final HalfBookImpl asks;

    BookImpl() {
        bids = new HalfBookImpl();
        asks = new HalfBookImpl();
    }

    @Override
    public HalfBook bids() {
        return bids;
    }

    @Override
    public HalfBook asks() {
        return asks;
    }

    void clear() {

    }

    @Override
    public ByteBuffer serialize() {
        return null;
    }
}
