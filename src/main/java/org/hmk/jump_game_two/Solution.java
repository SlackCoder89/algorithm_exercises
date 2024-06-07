package org.hmk.jump_game_two;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] inputs = new int[][]{
                {2,3,1,1,4},
                {2,3,0,1,4},
        };

        Solution s = new Solution();
        for (int[] input : inputs) {
            System.out.println(Arrays.toString(input) + ": " + s.jump(input));
        }
    }

    public int jump(int[] nums) {
        int count = 0;
        int start = 0, end = 0;
        while (end < nums.length - 1) {
            int nextEnd = -1;
            for (; start <= end; ++start) {
                int tmp = start + nums[start];
                nextEnd = Math.max(tmp, nextEnd);
            }
            end = nextEnd;
            count++;
        }

        return count;
    }
}
