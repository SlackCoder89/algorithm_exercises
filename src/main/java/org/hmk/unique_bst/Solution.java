package org.hmk.unique_bst;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int numTrees(int n) {
        Map<Integer, Long> cache = new HashMap<>();
        return doNumTrees(1, n, cache);
    }

    private static int doNumTrees(int start, int end, Map<Integer, Long> cache) {
        if (start >= end) {
            return 1;
        }

        if (cache.containsKey(end - start + 1)) {
            return cache.get(end - start + 1).intValue();
        }

        long count = 0;
        final int mod = 1000 * 1000 * 1000 + 7;
        for (int i = start; i <= end; ++i) {
            int left = doNumTrees(start, i - 1, cache);
            int right = doNumTrees(i + 1, end, cache);
            count += (long) left * right;
            count %= mod;
        }
        cache.put(end - start + 1, count);
        return (int)count;
    }
}
