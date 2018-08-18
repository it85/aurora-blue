package common.app.marketdata;

import common.object.Serializable;

public interface Book extends Serializable {

    HalfBook bids();

    HalfBook asks();

}
