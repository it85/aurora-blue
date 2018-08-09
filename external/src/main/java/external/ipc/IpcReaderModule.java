package external.ipc;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class IpcReaderModule extends AbstractModule {

    @Override
    public void configure() {
        bind(WireReader.class).to(ChronicleReader.class).in(Singleton.class);

        install(new FactoryModuleBuilder()
                .implement(WireReader.class, ChronicleReader.class)
                .build(WireReaderFactory.class));
    }
}
