package org.hmk.find_f_l;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][][] inputs = new int[][][]{
                {{5,7,7,8,8,10}, {8}},
                {{5,7,7,8,8,10}, {6}},
                {{}, {0}}
        };
        Solution solution = new Solution();
        for (int[][] input : inputs) {
            System.out.println(Arrays.deepToString(input) + ": " + Arrays.toString(solution.searchRange(input[0], input[1][0])));
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int index = findTarget(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int left = findLeft(nums, 0, index - 1, target);
        int right = findRight(nums, index + 1, nums.length - 1, target);
        if (left != -1) {
            left = Math.min(left, index);
        } else {
            left = index;
        }
        if (right != -1) {
            right = Math.max(right, index);
        } else {
            right = index;
        }
        return new int[]{left, right};
    }

    private int findRight(int[] nums, int start, int end, int target) {
        int preIndex = -1;
        int index = findTarget(nums, start, end, target);
        if (index == -1) {
            return preIndex;
        }
        while (index != -1) {
            preIndex = index;
            index = findTarget(nums, preIndex + 1, end, target);
        }
        return preIndex;
    }

    private int findLeft(int[] nums, int start, int end, int target) {
        int preIndex = -1;
        int index = findTarget(nums, start, end, target);
        if (index == -1) {
            return preIndex;
        }
        while (index != -1) {
            preIndex = index;
            index = findTarget(nums, start, preIndex - 1, target);
        }
        return preIndex;
    }

    private int findTarget(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int middle = (start + end) / 2;
        while (start <= end) {
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                return middle;
            }
            middle = (start + end) / 2;
        }

        return -1;
    }
}
