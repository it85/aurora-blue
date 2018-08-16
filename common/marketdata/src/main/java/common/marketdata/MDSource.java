package common.marketdata;

import common.connection.socket.SocketProtocol;
import common.core.message.Message;

public interface MDSource extends SocketProtocol {

    Message translate(String quote);

}