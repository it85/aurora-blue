package common.transport.messaging;

import java.nio.ByteBuffer;

public interface MutableMessageHeader extends MessageHeader {

    void id(short id);

    void size(int size);

    void payload(ByteBuffer buffer);

}
