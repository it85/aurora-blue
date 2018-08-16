package external.collection;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import common.core.collection.FastQueue;
import common.core.message.Message;

public class FastCollectionSingletonModule extends AbstractModule {

    @Override
    public void configure() {
        bind(new TypeLiteral<FastQueue<Message>>() {
        }).to(new TypeLiteral<LmaxFastMessageQueue>() {
        }).in(Singleton.class);
    }
}
