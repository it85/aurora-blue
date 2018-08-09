package common.transport.read;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

class TransportReaderModule extends AbstractModule {

    @Override
    public void configure() {
        bind(GenericReader.class).in(Singleton.class);
    }
}
