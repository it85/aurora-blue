package external.marketdata;

import com.google.gson.Gson;
import com.google.inject.Inject;
import common.connection.socket.SocketProtocol;
import common.core.message.Message;
import common.core.message.MessagingFactory;
import common.marketdata.MDSource;
import common.core.object.product.Instrument;

final class L2Gdax implements MDSource, SocketProtocol {

    private static final String ENDPOINT = "wss://ws-feed.gdax.com";    // TODO: Refactor into a common class

    private final MessagingFactory factory;
    private final Instrument instrument;
    private final BookImpl book;
    private final Gson gson;    // TODO: Get rid and use low-latency custom String parser

    @Inject
    L2Gdax(MessagingFactory factory) {
        this.factory = factory;

        this.instrument = new Instrument().symbol("BTC-USD");   // TODO: Inject a symbol?
        this.gson = new Gson();
        this.book = new BookImpl();
    }

    @Override
    public Message translate(String quote) {
        GdaxL2Snapshot snapshot = gson.fromJson(quote, GdaxL2Snapshot.class);

        switch (snapshot.type) {
            case GdaxL2Snapshot.CHANGE:
                update(snapshot);
                return factory.compose(book.serialize());
            case GdaxL2Snapshot.SNAPSHOT:
                snapshot(snapshot);
                return factory.compose(book.serialize());
            default:
                return factory.compose(book.serialize());
        }
    }

    @Override
    public String endpoint() {
        return ENDPOINT;
    }

    @Override
    public String sessionHandshake() {
        // TODO: use a more robust way to return the handshake
        return "{\"type\":\"subscribe\"," +
                "\"product_ids\":[\"" + instrument.symbol() + "\"]," +
                "\"channels\":[\"level2\"]" +
                "}";
    }

    // TODO: is it possible a snapshot could have both sell/buy changes?
    private void update(GdaxL2Snapshot snapshot) {
        book.clear();   // TODO: this is expensive
        if (snapshot.changes[0][0].equals("sell")) {
            book.asks().update(Double.parseDouble(snapshot.changes[0][1]), Double.parseDouble(snapshot.changes[0][2]));
        } else {
            book.bids().update(Double.parseDouble(snapshot.changes[0][1]), Double.parseDouble(snapshot.changes[0][2]));
        }
    }

    private void snapshot(GdaxL2Snapshot snapshot) {
        book.clear();   // TODO: this is expensive
        for (int i = 0; i < snapshot.bids.length; i++) {
            book.bids().update(Double.parseDouble(snapshot.bids[i][0]), Double.parseDouble(snapshot.bids[i][1]));
        }

        for (int i = 0; i < snapshot.asks.length; i++) {
            book.asks().update(Double.parseDouble(snapshot.asks[i][0]), Double.parseDouble(snapshot.asks[i][1]));
        }
    }

    private final class GdaxL2Snapshot {

        private static final String CHANGE = "l2update";
        private static final String SNAPSHOT = "snapshot";

        private String type;
        private String[][] bids;
        private String[][] asks;
        private String[][] changes;
    }
}
