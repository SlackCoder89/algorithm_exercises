package org.hmk.constrained_subset_sum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Sum> queue = new ArrayDeque<>();
        int[] sums = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; ++i) {
            Sum max = null;
            while (!queue.isEmpty()) {
                max = queue.getFirst();
                if (i - max.index <= k) {
                    break;
                } else {
                    queue.removeFirst();
                    max = null;
                }
            }
            if (max != null) {
                sums[i] = Math.max(sums[i], sums[i] + max.sum);
            }
            while (!queue.isEmpty()) {
                if (queue.getLast().sum < sums[i]) {
                    queue.removeLast();
                } else {
                    break;
                }
            }
            queue.addLast(new Sum(i, sums[i]));
        }

        int max = Integer.MIN_VALUE;
        for (int sum : sums) {
            max = Math.max(max, sum);
        }
        return max;
    }
}

class Sum {
    int index;
    int sum;

    public Sum(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }
}