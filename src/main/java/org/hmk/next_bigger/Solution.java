package org.hmk.next_bigger;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = findNextGreater(nums1[i], nums2);
        }
        return res;
    }

    private int findNextGreater(int n, int[] nums) {
        boolean comp = false;
        for (int num : nums) {
            if (num == n) {
                comp = true;
            }
            if (comp && num > n) {
                return num;
            }
        }
        return -1;
    }
}
