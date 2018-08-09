package common.transport.read;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class TransportReaderModule extends AbstractModule {

    @Override
    public void configure() {
        install(new FactoryModuleBuilder()
                .implement(GenericReader.class, GenericReader.class)
                .build(GenericReaderFactory.class));
    }
}
