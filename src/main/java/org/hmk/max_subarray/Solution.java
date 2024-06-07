package org.hmk.max_subarray;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(s.maxSubArray(new int[]{-1, -2}));
    }
    public int maxSubArray(int[] nums) {
        Sum sum = doMaxSubArray(nums, 0);
        return sum.maxSum;
    }

    private Sum doMaxSubArray(int[] nums, int index) {
        if (index == nums.length - 1) {
            return new Sum(nums[index], nums[index]);
        }
        Sum sum = doMaxSubArray(nums, index + 1);
        int prefixSum = Math.max(nums[index] + sum.prefixSum, nums[index]);
        int maxSum = Math.max(prefixSum, sum.maxSum);
        return new Sum(prefixSum, maxSum);
    }
}

class Sum {
    int prefixSum;
    int maxSum;

    public Sum(int prefixSum, int maxSum) {
        this.prefixSum = prefixSum;
        this.maxSum = maxSum;
    }
}
