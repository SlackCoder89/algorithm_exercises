package org.hmk.rotate_matrix;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[][] matrix = new int[][]{
                {
                    1, 2, 3, 4,
                },
                {
                    5, 6, 7, 8,
                },
                {
                    9, 10, 11, 12
                },
                {
                    13, 14, 15, 16
                }
        };
        solution1.rotate(matrix);
        for (int i = 0; i < matrix.length; ++i) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();

        matrix = new int[][]{
                {
                        1, 2, 3, 4,
                },
                {
                        5, 6, 7, 8,
                },
                {
                        9, 10, 11, 12
                },
                {
                        13, 14, 15, 16
                }
        };
        Solution2 solution2 = new Solution2();
        int[][] ret = solution2.rotate(matrix);
        for (int i = 0; i < ret.length; ++i) {
            System.out.println(Arrays.toString(ret[i]));
        }

    }
}
