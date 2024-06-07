package org.hmk.num_factored_binary_tree;

import java.util.*;

public class Solution2 {
    final int mod = 1000000007;

    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, List<int[]>> childrenMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            set.add(n);
        }

        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr.length; ++j) {
                int parent = arr[i] * arr[j];
                if (set.contains(parent)) {
                    int finalI = i;
                    int finalJ = j;
                    childrenMap.compute(parent, (k, v) -> {
                        if (v == null) {
                            v = new LinkedList<>();
                        }
                        v.add(new int[]{arr[finalI], arr[finalJ]});
                        return v;
                    });
                }
            }
        }

        Map<Integer, Long> dp = new HashMap<>();
        long res = 0;
        for (int r : arr) {
            res += calculateBinaryTree(r, childrenMap, dp);
            res %= mod;
        }
        return (int) res;
    }

    private long calculateBinaryTree(int r, Map<Integer, List<int[]>> childrenMap, Map<Integer, Long> dp) {
        if (dp.containsKey(r)) {
            return dp.get(r);
        }
        long count = 1;
        for (int[] children : childrenMap.getOrDefault(r, Collections.emptyList())) {
            int left = children[0];
            int right = children[1];
            long leftCount = calculateBinaryTree(left, childrenMap, dp);
            long rightCount = calculateBinaryTree(right, childrenMap, dp);
            if (right != left) {
                count = (count + leftCount * rightCount * 2) % mod;
            } else {
                count = (count + leftCount * rightCount) % mod;
            }
        }
        dp.put(r, count);
        return count;
    }
}
