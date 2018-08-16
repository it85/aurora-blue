package external.marketdata;

import com.google.inject.Inject;
import common.connection.socket.SocketProtocol;
import common.core.message.Message;
import common.core.message.MessagingFactory;
import common.marketdata.MDSource;

public class L3Gdax implements MDSource, SocketProtocol {

    private final MessagingFactory factory;

    @Inject
    L3Gdax(MessagingFactory factory) {
        this.factory = factory;
    }

    @Override
    public String endpoint() {
        return null;
    }

    @Override
    public String sessionHandshake() {
        return null;
    }

    @Override
    public Message translate(String quote) {
        return null;
    }
}
