package external.collection;

import common.core.collection.FastQueue;
import common.core.message.Message;

final class LmaxFastMessageQueue implements FastQueue<Message> {

    @Override
    public boolean add(Message message) {
        return false;
    }

    @Override
    public boolean offer(Message message) {
        return false;
    }

    @Override
    public Message remove() {
        return null;
    }

    @Override
    public Message poll() {
        return null;
    }

    @Override
    public Message element() {
        return null;
    }

    @Override
    public Message peek() {
        return null;
    }
}