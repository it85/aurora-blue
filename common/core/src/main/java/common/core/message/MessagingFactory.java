package common.core.message;

import java.nio.ByteBuffer;

/**
 * Packages raw data into messages and also converts raw bytes back into messages.
 */
public class MessagingFactory {

    private final MutableMessage message;

    public MessagingFactory() {
        message = null;
    }

    /**
     * Composes a message from the given raw ByteBuffer data
     *
     * @param buffer stores the raw data that we need to compose into a message
     */
    public Message compose(ByteBuffer buffer) {
        return message;
    }
}
