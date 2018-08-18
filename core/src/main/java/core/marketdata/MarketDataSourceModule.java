package core.marketdata;

import com.google.inject.AbstractModule;
import common.app.marketdata.Book;
import common.app.marketdata.HalfBook;
import common.app.marketdata.MutableBook;
import common.app.marketdata.MutableHalfBook;
import core.collection.map.FastMapModule;

public class MarketDataSourceModule extends AbstractModule {

    @Override
    public void configure() {
        install(new FastMapModule(false));

        bind(Book.class).to(BookImpl.class);
        bind(MutableBook.class).to(BookImpl.class);
        bind(HalfBook.class).to(HalfBookImpl.class);
        bind(MutableHalfBook.class).to(HalfBookImpl.class);
    }
}
