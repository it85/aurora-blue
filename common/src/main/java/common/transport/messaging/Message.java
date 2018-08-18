package common.transport.messaging;

import common.object.Serializable;

import java.nio.ByteBuffer;

public interface Message extends Serializable {

    /**
     * @return the message header
     */
    MessageHeader header();

    /**
     * @return the message payload
     */
    ByteBuffer payload();

}
