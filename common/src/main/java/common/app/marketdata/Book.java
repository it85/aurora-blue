package common.app.marketdata;

import common.object.Serializable;

public interface Book extends Serializable<MutableBook> {

    HalfBook bids();

    HalfBook asks();

}
