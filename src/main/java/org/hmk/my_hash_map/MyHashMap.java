package org.hmk.my_hash_map;

import java.util.LinkedList;
import java.util.ListIterator;

public class MyHashMap {
    LinkedList[] entries;
    int capacity = 0;
    int size = 0;
    double threshold = 0.7;
    public MyHashMap() {
        entries = new LinkedList[32];
        capacity = 32;
    }

    public MyHashMap(int capacity) {
        entries = new LinkedList[capacity];
        this.capacity = 32;
    }

    public void put(int key, int value) {
        int offset = key % capacity;
        if (entries[offset] == null) {
            entries[offset] = new LinkedList<Entry>();
            entries[offset].add(new Entry(key, value));
            size++;
            if (size > threshold * capacity) {
                rehash();
            }
        } else {
            for (Entry entry : (LinkedList<Entry>)entries[offset]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            entries[offset].add(new Entry(key, value));
        }
    }

    private void rehash() {
        MyHashMap newHashMap = new MyHashMap(capacity << 1);
        for (LinkedList<Entry> list : entries) {
            for (Entry entry : list) {
                newHashMap.put(entry.key, entry.value);
            }
        }
        entries = newHashMap.entries;
        capacity = newHashMap.capacity;
        size = newHashMap.size;
    }

    public int get(int key) {
        int offset = key % capacity;
        if (entries[offset] != null) {
            for (Entry entry : (LinkedList<Entry>)entries[offset]) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int offset = key % capacity;
        if (entries[offset] != null) {
            ListIterator<Entry> iterator = entries[offset].listIterator();
            while (iterator.hasNext()) {
                Entry cur = iterator.next();
                if (cur.key == key) {
                    iterator.remove();
                    return;
                }
            }
        }
    }

    class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
