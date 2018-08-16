package external.ipc;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import common.transport.write.WireWriter;

public class IpcWriterModule extends AbstractModule {

    @Override
    public void configure() {
        bind(WireWriter.class).to(ChronicleWriter.class).in(Singleton.class);
    }
}
