package common.app.marketdata;

import common.connection.socket.SocketProtocol;
import common.transport.messaging.Message;

public interface MDSource extends SocketProtocol {

    Message translate(String quote);

}