package org.hmk.sub_array_product;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            l[i] = 1;
            r[i] = 1;
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            l[i + 1] = l[i] * nums[i];
        }
        for (int j = nums.length - 1; j > 0; --j) {
            r[j - 1] = r[j] * nums[j];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            result[i] = l[i] * r[i];
        }
        return result;
    }
}
