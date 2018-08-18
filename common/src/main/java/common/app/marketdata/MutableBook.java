package common.app.marketdata;

public interface MutableBook extends Book {

    MutableHalfBook mutableBids();

    MutableHalfBook mutableAsks();

    void copyBids(MutableHalfBook src);

    void copyAsks(MutableHalfBook src);

    void clear();

}
