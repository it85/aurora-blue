package common.transport.write;

import java.nio.ByteBuffer;

public interface RawWriter {

    void write(ByteBuffer data);

}
