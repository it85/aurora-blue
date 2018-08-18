package core.ipc;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import common.transport.read.WireReader;
import common.transport.read.WireReaderFactory;

public class IpcReaderModule extends AbstractModule {

    @Override
    public void configure() {
        bind(WireReader.class).to(ChronicleReader.class).in(Singleton.class);

        install(new FactoryModuleBuilder()
                .implement(WireReader.class, ChronicleReader.class)
                .build(WireReaderFactory.class));
    }
}
