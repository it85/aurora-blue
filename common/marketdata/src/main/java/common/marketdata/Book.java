package common.marketdata;

import common.core.object.Serializable;

public interface Book extends Serializable {

    HalfBook bids();

    HalfBook asks();

}
