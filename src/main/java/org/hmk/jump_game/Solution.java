package org.hmk.jump_game;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] inputs = new int[][]{
                {2,3,1,1,4},
                {3,2,1,0,4},
                {0},
                {1, 2},
                {1, 2, 3}
        };

        Solution s = new Solution();
        for (int[] input : inputs) {
            System.out.println(Arrays.toString(input) + ": " + s.canJump(input));
        }
    }

    public boolean canJump(int[] nums) {
        Set<Integer> zeroDestination = new HashSet<>();
        zeroDestination.add(0);
        for (int i = 0; i <= nums[0]; ++i) {
            zeroDestination.add(i);
        }
        for (int i = 1; i < nums.length; ++i) {
            if (zeroDestination.contains(i)) {
                for (int j = 0; j <= nums[i]; ++j) {
                    int destination = i + j;
                    if (destination == nums.length - 1) {
                        return true;
                    }
                    zeroDestination.add(destination);
                }
            }
        }
        return zeroDestination.contains(nums.length - 1);
    }
}
