package org.hmk.sum_four;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        long newTarget = target;

        Set<List<Integer>> tmp = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = nums.length - 1; j > i; --j) {
                int start = i + 1;
                int end = j - 1;
                while (start < end) {
                    if ((long)nums[i] + nums[j] + nums[start] + nums[end] < newTarget) {
                        start++;
                    } else if ((long)nums[i] + nums[j] + nums[start] + nums[end] > newTarget) {
                        end--;
                    } else {
                        tmp.add(Arrays.asList(nums[i], nums[start], nums[end], nums[j]));
                        start++;
                    }
                }
            }
        }
        return new ArrayList<>(tmp);
    }
}
