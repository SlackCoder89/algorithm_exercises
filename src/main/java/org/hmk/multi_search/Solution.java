package org.hmk.multi_search;

import utils.HashMapList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        Trie tree = createTrieFromString(big);
        for (String s : smalls) {
            List<Integer> locations = tree.search(s);
            subtractValue(locations, s.length());

            lookup.put(s, locations);
        }
        return lookup;
    }

    private void subtractValue(List<Integer> locations, int delta) {
        if (locations == null) {
            return;
        }
        locations.replaceAll(integer -> integer - delta);
    }

    private Trie createTrieFromString(String s) {
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); ++i) {
            String suffix = s.substring(i);
            trie.insertString(suffix, i);
        }
        return trie;
    }
}

class Trie {
    private TrieNode root = new TrieNode();

    public Trie(String s) {
        insertString(s, 0);
    }

    public Trie() {}

    public List<Integer> search(String s) {
        return root.search(s);
    }

    public void insertString(String s, int location) {
        root.insertString(s, location);
    }

    public TrieNode getRoot() {
        return root;
    }
}

class TrieNode {
    private Map<Character, TrieNode> children;
    private List<Integer> indexes;
    private char value;

    public TrieNode() {
        children = new HashMap<>();
        indexes = new ArrayList<>();
    }

    public void insertString(String s, int index) {
        indexes.add(index);
        if (s != null && s.length() > 0) {
            value  = s.charAt(0);
            TrieNode child;
            if (children.containsKey(value)) {
                child = children.get(value);
            } else {
                child = new TrieNode();
                children.put(value, child);
            }
            String remainder = s.substring(1);
            child.insertString(remainder, index + 1);
        } else {
            children.put('\0', null);
        }
    }

    public List<Integer> search(String s) {
        if (s == null || s.length() == 0) {
            return indexes;
        } else {
            char first = s.charAt(0);
            if (children.containsKey(first)) {
                String remainder = s.substring(1);
                return children.get(first).search(remainder);
            }
        }
        return null;
    }

    public boolean terminates() {
        return children.containsKey('\0');
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }
}
