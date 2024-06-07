package org.hmk.sort_array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] inputs = new int[][]{
//                {5, 2, 3, 1},
                {5,1,1,2,0,0},
//                {-1,2,-8,-10}
        };

        Solution solution = new Solution();
        for (int[] input : inputs) {
            System.out.println(Arrays.toString(input) + ": " + Arrays.toString(solution.sortArray(input)));
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int small = start - 1;
        int big = end + 1;
        while (true) {
            do {
                small++;
            } while (nums[small] < pivot);

            do {
                big--;
            } while (nums[big] > pivot);

            if (small >= big) {
                return big;
            }
            swap(nums, small, big);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
