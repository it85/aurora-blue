package core.collection.queue;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import common.collection.queue.FastQueue;
import common.transport.messaging.Message;

public class FastQueueModule extends AbstractModule {

    private final boolean singleton;

    public FastQueueModule() {
        this(true);
    }

    public FastQueueModule(boolean singleton) {
        this.singleton = singleton;
    }

    @Override
    public void configure() {
        if (singleton) {
            bind(new TypeLiteral<FastQueue<Message>>() {
            }).to(new TypeLiteral<LmaxFastMessageQueue>() {
            }).in(Singleton.class);
        } else {
            bind(new TypeLiteral<FastQueue<Message>>() {
            }).to(new TypeLiteral<LmaxFastMessageQueue>() {
            });
        }
    }
}
