package core.collection.map;

import com.google.inject.Provider;
import common.collection.map.LongLongMap;

public class LongLongMapProvider implements Provider<LongLongMap> {

    @Override
    public LongLongMap get() {
        return new CarrotLongLongMap();
    }
}
