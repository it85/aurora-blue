package common.app.marketdata;

import common.object.Serializable;

public interface HalfBook extends Serializable<HalfBook> {

    long size(long price);

    int size();

    boolean isEmpty();

    long insidePrice();

    long insideSize();

}
