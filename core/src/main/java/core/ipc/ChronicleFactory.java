package core.ipc;

import net.openhft.chronicle.queue.ChronicleQueueBuilder;
import net.openhft.chronicle.queue.ExcerptAppender;
import net.openhft.chronicle.queue.ExcerptTailer;

final class ChronicleFactory {

    static ExcerptAppender acquireAppender(String path) {
        return ChronicleQueueBuilder.single(path).build().acquireAppender();
    }

    static ExcerptTailer createTailer(String path) {
        return ChronicleQueueBuilder.single(path).build().createTailer();
    }
}