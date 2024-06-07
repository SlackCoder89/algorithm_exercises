package org.hmk.rotate_matrix;

public class Solution2 {
    int[][] rotate(int[][] matrix) {
        int[][]ret = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0;j < matrix[0].length; ++j) {
                ret[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        return ret;
    }
}
