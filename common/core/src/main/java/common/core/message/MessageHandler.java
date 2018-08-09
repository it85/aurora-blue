package common.core.message;

public interface MessageHandler<T> {

    void handle(T message);

}
