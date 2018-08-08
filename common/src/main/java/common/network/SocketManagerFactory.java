package common.network;

import annotations.NoImplementation;
import common.message.MessageHandler;

@NoImplementation
public interface SocketManagerFactory {

    SocketManager create(MessageHandler<String> handler, SocketProtocol protocol);

}
