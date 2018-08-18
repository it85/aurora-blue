package core.marketdata;

import common.app.marketdata.HalfBook;

import java.nio.ByteBuffer;

final class HalfBookImpl implements HalfBook {

    @Override
    public void update(double price, double size) {

    }

    @Override
    public double size(double price) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public double insidePrice() {
        return 0;
    }

    @Override
    public double insideSize() {
        return 0;
    }

    void clear() {

    }

    @Override
    public ByteBuffer serialize() {
        return null;
    }
}
