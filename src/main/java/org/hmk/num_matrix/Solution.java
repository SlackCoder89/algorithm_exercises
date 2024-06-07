package org.hmk.num_matrix;

public class Solution {
    public static void main(String[] args) {
        NumMatrix matrix = new NumMatrix(new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5},
        });
        System.out.println(matrix.sumRegion(2,1,4,3));
    }
}
