package app.marketdata;

import com.google.inject.Inject;
import common.app.marketdata.MDSource;
import common.collection.queue.FastQueue;
import common.connection.socket.SocketManager;
import common.transport.messaging.Message;
import common.transport.messaging.MessageHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A single market data channel which supports a specific form of market data, e.g. L1, L2, or L3. Each channel spawns its
 * own thread for performing its work.
 * <p>
 * High Level Procedure
 * 1. open a socket connection using the SocketManager
 * 2. receive real-time market data
 * 3. normalize into internal data structure protocol
 * 4. persists into a buffer, i.e. {@link FastQueue}
 */
final class MDChannel implements Runnable, MessageHandler<String> {

    private static final Logger LOG = LogManager.getLogger(MDChannel.class);

    /**
     * Manages the connection to the market data source endpoint
     */
    private final SocketManager socketManager;

    /**
     * An abstraction of the market data source we're talking to
     */
    private final MDSource source;

    /**
     * Market data gets persisted into this queue
     */
    private final FastQueue<Message> buffer;

    @Inject
    MDChannel(SocketManager socketManager,
              FastQueue<Message> buffer,
              MDSource source) {
        this.socketManager = socketManager;
        this.source = source;
        this.buffer = buffer;

        socketManager.init(this, source);
    }

    @Override
    public void run() {
        socketManager.begin();
    }

    @Override
    public void handle(String message) {
        Message data = source.translate(message);
        buffer.add(data);

        if (LOG.isTraceEnabled()) {
            LOG.trace(data);
        }
    }
}
