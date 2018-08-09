package external.ipc;

import common.core.message.Message;

/**
 * Responsible for taking raw data and parsing into a domain-level POJO. Sub-classes are responsible for implementing
 * this. The 'external' module is nothing more than an abstraction on top of the wire-level libraries.
 */
public interface WireDataHandler {

    void handle(Message message);

}
