package external.ipc;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import common.core.message.MessageFactory;
import common.core.message.MutableMessage;
import net.openhft.chronicle.bytes.Bytes;
import net.openhft.chronicle.queue.ExcerptTailer;

import java.nio.ByteBuffer;

final class ChronicleReader implements WireReader {

    private final ExcerptTailer tailer;
    private final ByteBuffer buffer;
    private final MutableMessage message = null;
    private final Bytes bytes;

    @Inject
    ChronicleReader(@Assisted String path) {
        tailer = ChronicleFactory.createTailer(path);
        buffer = ByteBuffer.allocate(512);
        bytes = Bytes.wrapForWrite(buffer);
    }

    @Override
    public void poll(WireDataHandler handler) {
        if (tailer.readBytes(bytes)) {
            MessageFactory.formulate(buffer, message);
            handler.handle(message);
        }
    }
}
