package org.hmk.lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, LinkNode> map;
    LinkNode head;
    LinkNode tail;

    int capacity;
    int usage = 0;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new LinkNode(-1, -1, null, null);
        tail = new LinkNode(-1, -1, null, null);
        head.next = tail;
        tail.pre = head;
//        Map<Integer, Integer> m = new LinkedHashMap<>(capacity, 0.75, true);
        Map<Integer, Integer> m = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            move2First(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private void move2First(LinkNode node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkNode oldNode = map.get(key);
            if (oldNode.value == value) {
                move2First(oldNode);
            } else {
                removeLinkNode(oldNode);
                putValue(key, value);
            }
        } else {
            if (usage + 1 > capacity) {
                removeValue();
            }
            putValue(key, value);
            usage++;
        }
    }

    private void putValue(int key, int value) {
        LinkNode newNode = new LinkNode(key, value, null, null);
        map.put(key, newNode);
        offerNode(newNode);
    }

    private void removeValue() {
        LinkNode toRemove = tail.pre;
        removeLinkNode(toRemove);
        map.remove(toRemove.key);
    }

    private void offerNode(LinkNode newNode) {
        newNode.next = head.next;
        newNode.pre = head;

        head.next.pre = newNode;
        head.next = newNode;
    }

    private void removeLinkNode(LinkNode toRemove) {
        toRemove.pre.next = toRemove.next;
        toRemove.next.pre = toRemove.pre;
    }

    public String printMap() {
        StringBuffer res = new StringBuffer();
        res.append("{");
        for (Map.Entry e : map.entrySet()) {
           String en = String.format("[%s : %s],", e.getKey(), ((LinkNode)e.getValue()).value);
           res.append(en);
        }
        return res.toString();
    }

    public String printLink() {
        StringBuffer res = new StringBuffer();
        res.append("{");
        LinkNode c = head;
        while (c != null) {
            String e = String.format("[%s : %s] -> ", c.key, c.value);
            res.append(e);
            c = c.next;
        }
        res.append("}");
        return res.toString();
    }
}

class LinkNode {
    int key;
    int value;
    LinkNode pre;
    LinkNode next;

    public LinkNode(int key, int value, LinkNode pre, LinkNode next) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}
