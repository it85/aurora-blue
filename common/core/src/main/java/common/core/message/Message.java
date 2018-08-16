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

    /**
     * @return the entire message, header included, as a {@link ByteBuffer}
     */
    ByteBuffer serialize();

}
