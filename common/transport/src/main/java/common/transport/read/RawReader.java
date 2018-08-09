package common.transport.read;

public interface RawReader {

    void poll(WireDataHandler handler);

}