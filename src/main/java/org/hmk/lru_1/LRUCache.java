package org.hmk.lru_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    int capacity;
    int size;
    Map<Integer, Value> cache = new HashMap<>();
    LinkedList<Value> list = new LinkedList<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int res = -1;
        if (cache.containsKey(key)) {
            Value value = cache.get(key);
            res = value.value;
            // TODO
        }
        return res;
    }

    public void put(int key, int value) {

    }
}

class Value {
    int key;
    int value;
}