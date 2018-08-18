package common.connection.socket;

import common.annotations.NoImplementation;
import common.transport.messaging.MessageHandler;

@NoImplementation
public interface SocketManagerFactory {

    SocketManager create(MessageHandler<String> handler, SocketProtocol protocol);

}
