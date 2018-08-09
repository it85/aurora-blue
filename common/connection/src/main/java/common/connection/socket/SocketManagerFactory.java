package common.connection.socket;

import common.core.annotations.NoImplementation;
import common.core.message.MessageHandler;

@NoImplementation
public interface SocketManagerFactory {

    SocketManager create(MessageHandler<String> handler, SocketProtocol protocol);

}
