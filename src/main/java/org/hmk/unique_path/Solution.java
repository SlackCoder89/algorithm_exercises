package org.hmk.unique_path;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int uniquePaths(int m, int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return dfs(0, 0, m, n, cache);
    }

    private int dfs(int x, int y, int m, int n, Map<Integer, Integer> cache) {
        int p = x + 1 + y * n;
        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        if (y == m - 1 && x == n - 1) {
            return 1;
        }

        if (y >= m || x >= n) {
            return 0;
        }

        int tmp = dfs(x + 1, y, m, n, cache) + dfs(x, y + 1, m, n, cache);
        cache.put(x + 1 + y * n, tmp);
        return tmp;
    }
}
