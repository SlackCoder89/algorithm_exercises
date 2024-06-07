package org.hmk.num_factored_binary_tree;

import java.util.*;

public class Solution {
    final int MOD = 1000 * 1000 * 1000 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, List<int[]>> childrenMap = new HashMap<>();
        Set<Long> set = new HashSet<>();
        for (int n : arr) {
            set.add((long)n);
        }

        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr.length; ++j) {
                long parent = (long)arr[i] * arr[j];
                if (set.contains(parent)) {
                    int finalI = i;
                    int finalJ = j;
                    childrenMap.compute((int) parent, (k, v) -> {
                        if (v == null) {
                            v = new LinkedList<>();
                        }
                        v.add(new int[]{arr[finalI], arr[finalJ]});
                        return v;
                    });
                }
            }
        }


        Map<Integer, Long> cache = new HashMap<>();
        long count = 0;
        for (int r : arr) {
            count += calculateBinaryTree(r, childrenMap, cache);
            count %= MOD;
        }
        return (int) count;
    }

    private long calculateBinaryTree(int n, Map<Integer, List<int[]>> childrenMap, Map<Integer, Long> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        long count = 1;
        for (int[] children : childrenMap.getOrDefault(n, Collections.emptyList())) {
            long tmpCount1 = calculateBinaryTree(children[0], childrenMap, cache);
            long tmpCount2 = tmpCount1;
            long tmpCount = tmpCount1 * tmpCount2;

            if (children[0] != children[1]) {
                tmpCount2 = calculateBinaryTree(children[1], childrenMap, cache);
                tmpCount = tmpCount1 * tmpCount2;
                tmpCount *= 2;
            }
            count += tmpCount;
            count %= MOD;
        }
        cache.put(n, count);
        return count;
    }
}
