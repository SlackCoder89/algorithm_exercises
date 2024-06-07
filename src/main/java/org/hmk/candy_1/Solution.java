package org.hmk.candy_1;

public class Solution {
    public int candy(int[] ratings) {
        int[] nums = new int[ratings.length];
        for (int i = 0; i < ratings.length; ++i) {
            if (i == 0) {
                nums[i] = 1;
            } else if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            } else if (ratings[i] < ratings[i - 1]) {
                fillDownSlope(i, ratings, nums);
            } else {
                nums[i] = 1;
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private void fillDownSlope(int start, int[] ratings, int[] nums) {
        int end = start;
        for (; end < nums.length - 1; ++end) {
            if (ratings[end + 1] > ratings[end]) {
                break;
            }
        }
        for (int i = end - 1; i >= start; --i) {
        }
    }

    private void adjustCandy(int index, int[] ratings, int[] nums) {
        for (int i = index; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1] && nums[i] <= nums[i + 1]) {
                nums[i] = nums[i + 1] + 1;
            } else {
                break;
            }
        }
    }
}
