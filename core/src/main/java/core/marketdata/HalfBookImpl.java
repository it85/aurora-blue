package core.marketdata;

import com.google.inject.Inject;
import common.app.marketdata.HalfBook;
import common.app.marketdata.MutableHalfBook;
import common.collection.map.LongLongMap;

import java.nio.ByteBuffer;

final class HalfBookImpl implements MutableHalfBook {

    private final LongLongMap book;

    @Inject
    HalfBookImpl(LongLongMap map) {
        this.book = map;
    }

    @Override
    public void update(long price, long size) {
        book.put(price, size);
    }

    @Override
    public long size(long price) {
        return book.get(price);
    }

    @Override
    public int size() {
        return book.size();
    }

    @Override
    public boolean isEmpty() {
        return book.isEmpty();
    }

    @Override
    public long insidePrice() {
        return 0;
    }

    @Override
    public long insideSize() {
        return 0;
    }

    @Override
    public void clear() {
        book.clear();
    }

    @Override
    public ByteBuffer serialize() {
        return null;
    }

    @Override
    public void deserialize(HalfBook target) {

    }
}
