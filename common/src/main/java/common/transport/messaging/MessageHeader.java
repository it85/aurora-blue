package common.transport.messaging;

public interface MessageHeader {

    /**
     * @return a unique identifier for the type of message this is
     */
    short id();

    /**
     * @return the absolute total size of this message, from start of header to end of payload
     */
    int size();

}
