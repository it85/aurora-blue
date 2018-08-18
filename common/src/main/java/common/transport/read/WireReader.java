package common.transport.read;

public interface WireReader {

    void poll(WireDataHandler handler);

}