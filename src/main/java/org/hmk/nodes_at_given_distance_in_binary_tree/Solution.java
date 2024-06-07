package org.hmk.nodes_at_given_distance_in_binary_tree;

import java.util.*;

public class Solution {
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        convert2Graph(root, map);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        Set<Integer> visited = new HashSet<>();
        int count = k;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Integer i = queue.poll();
                for (Integer n : map.get(i)) {
                    if (visited.contains(n)) {
                        continue;
                    }
                    queue.offer(n);
                }
                visited.add(i);
                size--;
            }
            count--;
            if (count == 0) {
                break;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        res.sort(Integer::compareTo);
        return res;
    }

    private static void convert2Graph(Node root, Map<Integer, List<Integer>> map) {
        dfs(root, map);
    }

    private static void dfs(Node root, Map<Integer, List<Integer>> map) {
        if (root.left != null) {
            extracted(root, root.left, map);
        }
        if (root.right != null) {
            extracted(root, root.right, map);
        }
    }

    private static void extracted(Node n1, Node n2, Map<Integer, List<Integer>> map) {
        map.compute(n1.data, (k, v) -> {
            if (v == null) {
                v = new ArrayList<>();
            }
            v.add(n2.data);
            return v;
        });
        map.compute(n2.data, (k, v) -> {
            if (v == null) {
                v = new ArrayList<>();
            }
            v.add(n1.data);
            return v;
        });
        dfs(n2, map);
    }
}
