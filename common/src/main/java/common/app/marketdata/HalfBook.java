package common.app.marketdata;

import common.object.Serializable;

public interface HalfBook extends Serializable {

    void update(double price, double size);

    double size(double price);

    int size();

    boolean empty();

    double insidePrice();

    double insideSize();

}
