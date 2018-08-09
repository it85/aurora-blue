package common.core.message;

import java.nio.ByteBuffer;

public interface Message {

    /**
     * @return the message header
     */
    MessageHeader header();

    /**
     * @return the message payload
     */
    ByteBuffer payload();

}
