package common.transport.read;

import java.nio.ByteBuffer;

public interface WireDataHandler {

    void handle(ByteBuffer buffer);

}
