package external.connection;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class ExternalSocketModule extends AbstractModule {

    @Override
    public void configure() {
        bind(new TypeLiteral<Socket<String>>() {
        }).to(new TypeLiteral<JettySocket>() {
        });
    }
}
