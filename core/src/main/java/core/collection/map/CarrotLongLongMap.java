package core.collection.map;

import com.carrotsearch.hppc.LongLongHashMap;
import com.carrotsearch.hppc.LongLongMap;

final class CarrotLongLongMap implements common.collection.map.LongLongMap {

    private final LongLongMap map;

    CarrotLongLongMap() {
        map = new LongLongHashMap();
    }

    @Override
    public void put(long k, long v) {
        map.put(k, v);
    }

    @Override
    public long get(long k) {
        return map.get(k);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean contains(long k) {
        return map.containsKey(k);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
}
