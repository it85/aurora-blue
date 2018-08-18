package common.app.marketdata;

public interface MutableHalfBook extends HalfBook {

    void update(long price, long size);

    void clear();

}
