package org.hmk.num_matrix;

public class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                sumMatrix[i + 1][j + 1] = sumMatrix[i + 1][j] + matrix[i][j];
            }
        }
        for (int j = 1; j < sumMatrix[0].length; ++j) {
            for (int i = 1; i < sumMatrix.length; ++i) {
                sumMatrix[i][j] += sumMatrix[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1] + sumMatrix[row1][col1];
    }
}