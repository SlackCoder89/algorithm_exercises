package org.hmk.container_with_most_water;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] heights = new int[][]{
                {1,8,6,2,5,4,8,3,7},
//                {1,1},
        };

        Solution s = new Solution();
        for (int[] height : heights) {
            System.out.println(Arrays.toString(height) + ": " + s.maxArea(height));
        }
    }

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int tmp = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(tmp, max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
