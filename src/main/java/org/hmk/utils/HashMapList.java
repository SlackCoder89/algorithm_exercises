package org.hmk.utils;

import java.util.*;

public class HashMapList<T, E> {
    private Map<T, List<E>> map = new HashMap<>();

    public void put(T key, E item) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(item);
    }

    public void put(T key, List<E> items) {
        map.put(key, items);
    }

    public List<E> get(T key) {
        return map.get(key);
    }

    public boolean containsKeyValue(T key, E value) {
        List<E> list = get(key);
        if (list == null) {
            return false;
        }
        return list.contains(value);
    }

    public Set<T> keySet() {
        return map.keySet();
    }

    public String toString() {
        return map.toString();
    }
}
