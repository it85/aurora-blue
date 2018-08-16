package common.transport.write;

import java.nio.ByteBuffer;

public interface WireWriter {

    void write(ByteBuffer data);

}
