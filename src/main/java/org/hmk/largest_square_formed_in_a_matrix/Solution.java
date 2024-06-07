package org.hmk.largest_square_formed_in_a_matrix;

public class Solution {
    static int maxSquare(int n, int m, int mat[][]){
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 1) {
                    int len = calMaxLen(i, j, mat);
                    max = Math.max(len, max);
                }
            }
        }
        return max;
    }

    private static int calMaxLen(int r, int c, int[][] mat) {
        int offset = 1;
        while (r + offset < mat.length && c + offset < mat[0].length) {
            for (int j = r; j <= r + offset; ++j) {
                if (mat[j][c + offset] == 0) {
                    return offset;
                }
            }
            for (int j = c; j <= c + offset; ++j) {
                if (mat[r + offset][j] == 0) {
                    return offset;
                }
            }
            offset++;
        }
        return offset;
    }
}
