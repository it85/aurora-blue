package external.ipc;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import common.core.message.Message;
import common.core.message.MessagingFactory;
import common.transport.read.WireDataHandler;
import common.transport.read.WireReader;
import net.openhft.chronicle.bytes.Bytes;
import net.openhft.chronicle.queue.ExcerptTailer;

import java.nio.ByteBuffer;

final class ChronicleReader implements WireReader {

    private final ExcerptTailer tailer;
    private final ByteBuffer buffer;
    private final MessagingFactory messagingFactory;
    private final Bytes bytes;

    @Inject
    ChronicleReader(MessagingFactory messagingFactory,
                    @Assisted String path) {
        this.messagingFactory = messagingFactory;

        tailer = ChronicleFactory.createTailer(path);
        buffer = ByteBuffer.allocate(512);
        bytes = Bytes.wrapForWrite(buffer);
    }

    @Override
    public void poll(WireDataHandler handler) {
        if (tailer.readBytes(bytes)) {
            Message message = messagingFactory.compose(buffer);
            handler.handle(message);
        }
    }
}
