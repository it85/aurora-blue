package common.message;

public interface MessageHandler<T> {

    void handle(T message);

}
