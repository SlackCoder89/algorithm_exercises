package org.hmk.minimum_size_sub;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = a;
        a = b;
        b = c;
        System.out.println("a :"  + a);
        System.out.println("b :" + b);
        int[][][] inputs = new int[][][]{
                {{7}, {2,3,1,2,4,3}},
//                {{4}, {1,4,4}},
//                {{11}, {1,1,1,1,1,1,1,1}},
        };

        Solution solution = new Solution();
        for (int[][] input : inputs) {
            System.out.println(Arrays.deepToString(input) + ": " + solution.minSubArrayLen(input[0][0], input[1]));
        }
    }
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
