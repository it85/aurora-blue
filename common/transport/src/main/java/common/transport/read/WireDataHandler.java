package common.transport.read;

import java.nio.ByteBuffer;

/**
 * Responsible for taking raw data and parsing into a domain-level POJO
 */
public interface WireDataHandler {

    void handle(ByteBuffer buffer);

}
