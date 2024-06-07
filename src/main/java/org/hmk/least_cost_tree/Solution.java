package org.hmk.least_cost_tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int mctFromLeafValues(int[] arr) {
        int min = Integer.MAX_VALUE;
        Map<List<Integer>, TreeNode> cache = new HashMap<>();
        for (int i = 0; i < arr.length - 1; ++i) {
            TreeNode left = mcfFromLeafValues(arr, 0, i, cache);
            TreeNode right = mcfFromLeafValues(arr, i + 1, arr.length - 1, cache);
            int value = left.max * right.max;
            value += left.value + right.value;
            min = Math.min(min, value);
        }
        return min;
    }

    private TreeNode mcfFromLeafValues(int[] arr, int start, int end, Map<List<Integer>, TreeNode> cache) {
        if (cache.containsKey(Arrays.asList(start, end))) {
            return cache.get(Arrays.asList(start, end));
        }
        if (start == end) {
            cache.put(Arrays.asList(start, end), new TreeNode(arr[start], 0));
            return cache.get(Arrays.asList(start, end));
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; ++i) {
            TreeNode left = mcfFromLeafValues(arr, start, i, cache);
            TreeNode right = mcfFromLeafValues(arr, i + 1, end, cache);

            int value = left.max * right.max;
            value += left.value + right.value;
            min = Math.min(min, value);

            int tmpMax = Math.max(left.max, right.max);
            max = Math.max(max, tmpMax);
        }
        cache.put(Arrays.asList(start, end), new TreeNode(max, min));
        return cache.get(Arrays.asList(start, end));
    }
}

class TreeNode {
    int max;
    int value;

    public TreeNode(int max, int value) {
        this.max = max;
        this.value = value;
    }
}
