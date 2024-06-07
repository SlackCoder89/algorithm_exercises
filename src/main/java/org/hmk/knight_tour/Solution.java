package org.hmk.knight_tour;

public class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int[][] steps = new int[grid.length * grid.length][2];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0;j < grid.length; ++j) {
                steps[grid[i][j]] = new int[]{i, j};
            }
        }

        int x = 0;
        int y = 0;
        for (int i = 1; i < steps.length; ++i) {
            if (!validate(new int[]{x, y}, steps[i])) {
                return false;
            }
            x = steps[i][0];
            y = steps[i][1];
        }
        return true;
    }

    private boolean validate(int[] step1, int[] step2) {
        int diffX = Math.abs(step1[0] - step2[0]);
        int diffY = Math.abs(step1[1] - step2[1]);
        return diffX * diffY == 2;
    }
}
