package org.hmk.median_of_two_sorted_arrays;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][][] inputs = new int[][][]{
                {
                        {1,3}, {2}
                },
                {
                        {1,2}, {3,4}
                }
        };

        Solution s = new Solution();
        for (int[][] is : inputs) {
            System.out.println(Arrays.deepToString(is) + ": " + s.findMedianSortedArrays(is[0], is[1]));
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tmp = new int[nums1.length + nums2.length];
        int j = 0, k = 0;
        for (int i = 0; i < tmp.length; ++i) {
           if (j < nums1.length && k < nums2.length && nums1[j] < nums2[k]) {
               tmp[i] = nums1[j];
               ++j;
           } else if (j < nums1.length && k < nums2.length && nums1[j] >= nums2[k]) {
               tmp[i] = nums2[k];
               ++k;
           } else if (j >= nums1.length) {
               tmp[i] = nums2[k];
               ++k;
           } else {
               tmp[i] = nums1[j];
               ++j;
           }
        }

        if (tmp.length % 2 == 1) {
           return tmp[tmp.length / 2];
        } else {
            return ((double)tmp[tmp.length / 2 - 1] + (double)tmp[tmp.length / 2]) / 2;
        }
    }
}