package common.transport.messaging;

public interface MessageHandler<T> {

    void handle(T message);

}
