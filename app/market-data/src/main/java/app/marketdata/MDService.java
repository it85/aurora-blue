package app.marketdata;


import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static common.app.marketdata.MarketDataType.L2;

/**
 * Encapsulates, and initializes, multiple market data channels. This class is responsible for starting up enabled
 * channels.
 */
final class MDService {

    private static final Logger LOG = LogManager.getLogger(MDChannel.class);

    //    private final MDChannel level1;   // TODO: implement L1 at some point
    private final MDChannel level2;
//    private final MDChannel level3;

    private boolean l2Enabled;
    private boolean l3Enabled;

    @Inject
    MDService(MDChannelFactory factory) {
        level2 = factory.create(L2);
//        level3 = factory.create(L3);
    }

    void enableL2() {
        l2Enabled = true;
    }

    void enableL3() {
        l3Enabled = true;
    }

    void start() {
        if (l2Enabled) {
            LOG.debug("Starting Level 2 market data channel");
            new Thread(level2).start();
        }

        if (l3Enabled) {
            LOG.debug("Starting Level 3 market data channel");
//            new Thread(level3).start();
        }
    }
}
