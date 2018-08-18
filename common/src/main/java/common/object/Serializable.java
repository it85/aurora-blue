package common.object;

import java.nio.ByteBuffer;

public interface Serializable<T> {

    ByteBuffer serialize();

    void deserialize(T target);

}
