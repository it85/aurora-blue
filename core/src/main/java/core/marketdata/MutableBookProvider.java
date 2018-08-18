package core.marketdata;

import com.google.inject.Inject;
import com.google.inject.Provider;
import common.app.marketdata.MutableBook;

public class MutableBookProvider implements Provider<MutableBook> {

    private final MutableHalfBookProvider bookProvider;

    @Inject
    MutableBookProvider(MutableHalfBookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    @Override
    public MutableBook get() {
        return new BookImpl(bookProvider.get(), bookProvider.get());
    }
}
