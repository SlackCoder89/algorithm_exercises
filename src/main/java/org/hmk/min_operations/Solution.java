package org.hmk.min_operations;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        int sum = total - x;

        int tmp = 0;
        int length = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        while (true) {
            if (tmp == sum) {
                length = Math.max(end - start + 1, length);
                if (start == -1) {
                    length--;
                }
                if (end + 1 < nums.length) {
                    ++end;
                    tmp += nums[end];
                } else {
                    break;
                }
            } else if (tmp < sum) {
                if (end + 1 < nums.length) {
                    end++;
                    tmp += nums[end];
                } else {
                    break;
                }
            } else {
                if (start <= end) {
                    if (start == -1) {
                        ++start;
                        continue;
                    }
                    tmp -= nums[start];
                    ++start;
                } else {
                    break;
                }
            }
        }
        if (length == Integer.MIN_VALUE) {
            return -1;
        } else {
            return nums.length - length;
        }
    }
}