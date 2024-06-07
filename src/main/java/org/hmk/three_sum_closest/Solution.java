package org.hmk.three_sum_closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int start = 0;
            int end = nums.length - 1;
            if (start == i) {
                start = start + 1;
            }
            if (end == i) {
                end = end - 1;
            }

            while (start < end) {
                int tmp = nums[i] + nums[start] + nums[end];
                if (Math.abs(tmp - target) < Math.abs(sum - target)) {
                    sum = tmp;
                }
                if (tmp > target) {
                    end = end -1;
                    if (end == i) {
                        end = end - 1;
                    }
                } else if (tmp < target)  {
                    start = start + 1;
                    if (start == i) {
                        start = start + 1;
                    }
                } else {
                    return target;
                }
            }
        }
        return sum;
    }
}
