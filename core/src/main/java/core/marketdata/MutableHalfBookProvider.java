package core.marketdata;

import com.google.inject.Inject;
import com.google.inject.Provider;
import common.app.marketdata.MutableHalfBook;
import core.collection.map.LongLongMapProvider;

public class MutableHalfBookProvider implements Provider<MutableHalfBook> {

    private final LongLongMapProvider mapProvider;

    @Inject
    public MutableHalfBookProvider(LongLongMapProvider mapProvider) {
        this.mapProvider = mapProvider;
    }

    @Override
    public MutableHalfBook get() {
        return new HalfBookImpl(mapProvider.get());
    }
}
