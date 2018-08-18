package common.collection.map;

/**
 * Maps a long to a long efficiently without auto-boxing
 */
public interface LongLongMap {

    void put(long k, long v);

    long get(long k);

    int size();

    boolean contains(long k);

    void clear();

    boolean isEmpty();

}
