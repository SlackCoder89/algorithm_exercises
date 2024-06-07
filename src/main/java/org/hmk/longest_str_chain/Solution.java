package org.hmk.longest_str_chain;

import java.util.*;

public class Solution {
    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> lenMap = new HashMap<>();
        for (String word : words) {
            lenMap.compute(word.length(), (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(word);
                return v;
            });
        }

        Map<Integer, List<Node>> nodeMap = new HashMap<>();
        List<Integer> lens = new ArrayList<>(lenMap.keySet());
        int ret = Integer.MIN_VALUE;
        for (Integer i : lens) {
            for (String word : lenMap.get(i)) {
                Node node = constructNode(word, nodeMap);
                ret = Math.max(ret, node.level);
                nodeMap.compute(i, (k, v) -> {
                    if (v == null) {
                        v = new ArrayList<>();
                    }
                    v.add(node);
                    return v;
                });
            }
        }
        return ret;
    }

    private Node constructNode(String word, Map<Integer, List<Node>> nodeMap) {
        List<Node> parents = nodeMap.getOrDefault(word.length() - 1, Collections.emptyList());
        Node cur = new Node(word, 1, new ArrayList<>());
        for (Node node : parents) {
            if (isPredecessor(node.word, word)) {
                cur.level = Math.max(cur.level, node.level + 1);
                node.children.add(cur);
            }
        }
        return cur;
    }

    private boolean isPredecessor(String s1, String s2) {
        int i = 0;
        int j = 0;
        boolean hasDifference = false;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                ++i;
                ++j;
            } else if (!hasDifference) {
                hasDifference = true;
                ++j;
            } else {
                return false;
            }
        }
        return true;
    }
}

class Node {
    String word;
    int level;
    List<Node> children;

    public Node(String word, int level, List<Node> children) {
        this.word = word;
        this.level = level;
        this.children = children;
    }
}
