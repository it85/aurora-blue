package app.marketdata;

import com.google.inject.Inject;
import common.collection.queue.FastQueue;
import common.transport.messaging.Message;
import common.transport.write.WireWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.ByteBuffer;

/**
 * This class initializes the Market Data service {@link MDService} which is writing market data into a shared buffer.
 */
public final class MDS implements Runnable {

    private static final Logger LOG = LogManager.getLogger(MDS.class);

    private final MDService service;
    private final WireWriter writer;
    private final FastQueue<Message> buffer;

    @Inject
    public MDS(MDService service, WireWriter writer, FastQueue<Message> buffer) {
        this.service = service;
        this.buffer = buffer;
        this.writer = writer;

        // TODO: abstract out the enabling of different channels out of this class?
        service.enableL2();
//        service.enableL3();
    }

    @Override
    public void run() {
        init();
        poll();
    }

    private void init() {
        LOG.debug("Starting up market data service");
        service.start();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void poll() {
        // TODO: improve busy spin policy?
        while (true) {
            if (buffer.peek() != null) {
                if (LOG.isTraceEnabled()) {
                    LOG.trace(buffer.peek());
                }
                final ByteBuffer b = buffer.poll().serialize();
                writer.write(b);
            }
        }
    }
}
