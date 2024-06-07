package org.hmk.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionCount = 4;
        int numCount = matrix.length * matrix[0].length;
        int currentCount = 0;
        List<Integer> res = new ArrayList<>(numCount);
        int x = 0;
        int y = 0;
        int directionIndex = 0;

        while (currentCount < numCount) {
            res.add(matrix[x][y]);
            currentCount++;
            matrix[x][y] = Integer.MIN_VALUE;
            int nx = x + direction[directionIndex][0];
            int ny = y + direction[directionIndex][1];
            if (nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length || matrix[nx][ny] == Integer.MIN_VALUE) {
                directionIndex = (directionIndex + 1) % 4;
            }
            x = x + direction[directionIndex][0];
            y = y + direction[directionIndex][1];
        }

        return res;
    }
}
