package org.hmk.three_sum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] inputs = new int[][]{
//                {-1,0,1,2,-1,-4},
//                {0,1,1},
//                {0,0,0},
                {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}
        };
        Solution s = new Solution();
        for (int[] is : inputs) {
            System.out.println(Arrays.toString(is) + ": " + s.threeSum(is));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> s = new ArrayList<>();
        int prevI = Integer.MIN_VALUE;
        int prevJ = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int ni = nums[i];
            if (ni == prevI) {
                continue;
            }
            prevI = ni;

            boolean changeJ = false;
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int nj = nums[j];
                if (changeJ && nj == prevJ) {
                    ++j;
                    continue;
                }
                prevJ = nj;

                int sum = ni + nj + nums[k];
                if (sum == 0) {
                    s.add(Arrays.asList(ni, nj, nums[k]));
                    ++j;
                    changeJ = true;
                } else if (sum > 0) {
                    --k;
                    changeJ = false;
                } else {
                    ++j;
                    changeJ = true;
                }
            }
        }

        return s;
    }
}
