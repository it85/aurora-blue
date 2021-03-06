package common.transport.read;

import common.transport.messaging.Message;

/**
 * Responsible for taking raw data and parsing into a domain-level POJO. Sub-classes are responsible for implementing
 * this. The 'core' module is nothing more than an abstraction on top of the wire-level libraries.
 */
public interface WireDataHandler {

    void handle(Message message);

}
