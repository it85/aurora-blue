package common.transport.read;

public interface WireReaderFactory {

    WireReader create(String path);
}
