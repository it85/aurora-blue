package common.transport.read;

import com.google.inject.Inject;
import external.ipc.WireReader;
import external.ipc.WireDataHandler;

/**
 * This is the primary entry point for any event-driven component. The client should instantiate and start a new thread
 * for this class to kick off the event-driven loop.
 */
final class GenericReader implements Runnable {

    private final WireReader reader;
    private final WireDataHandler handler;

    @Inject
    GenericReader(WireReader reader,
                  WireDataHandler handler) {
        this.reader = reader;
        this.handler = handler;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run() {
        while (true) {
            reader.poll(handler);
        }
    }
}
