package core.collection.map;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import common.collection.map.LongLongMap;

public class FastMapModule extends AbstractModule {

    private final boolean singleton;

    public FastMapModule() {
        this(true);
    }

    public FastMapModule(boolean singleton) {
        this.singleton = singleton;
    }

    @Override
    public void configure() {
        if (singleton) {
            bind(LongLongMap.class).to(CarrotLongLongMap.class).in(Singleton.class);
        } else {
            bind(LongLongMap.class).to(CarrotLongLongMap.class);
        }
    }
}
