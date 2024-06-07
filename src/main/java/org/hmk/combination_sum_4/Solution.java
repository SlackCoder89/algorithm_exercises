package org.hmk.combination_sum_4;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int ret = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int n : nums) {
            ret += doCombination(nums, target - n, cache);
        }
        return ret;
    }

    private int doCombination(int[] nums, int target, Map<Integer, Integer> cache) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        int ret = 0;
        for (int n : nums) {
            ret += doCombination(nums, target - n, cache);
        }
        cache.put(target, ret);
        return ret;
    }
}
