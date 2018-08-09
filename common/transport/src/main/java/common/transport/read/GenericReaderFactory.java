package common.transport.read;

import common.core.annotations.NoImplementation;

@NoImplementation
public interface GenericReaderFactory {

    GenericReader create(WireDataHandler handler);

}
