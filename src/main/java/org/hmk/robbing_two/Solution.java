package org.hmk.robbing_two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int rob(int[] nums) {
        Map<List<Integer>, Integer> cache = new HashMap<>();
        int a = nums[0] + doRob(nums, 2, nums.length - 2, cache);
        int b = doRob(nums, 1, nums.length - 1, cache);
        return Math.max(a, b);
    }

    private int doRob(int[] nums, int start, int end, Map<List<Integer>, Integer> cache) {
        if (start > end) {
            return 0;
        }
        if (cache.containsKey(Arrays.asList(start, end))) {
            return cache.get(Arrays.asList(start, end));
        }
        if (start == end) {
            return nums[start];
        }
        if (start + 1 == end) {
            return Math.max(nums[start], nums[end]);
        }

        int a = nums[start] + doRob(nums, start + 2, end, cache);
        int b = doRob(nums, start + 1,  end, cache);
        int res = Math.max(a, b);
        cache.put(Arrays.asList(start, end), res);
        return res;
    }
}
