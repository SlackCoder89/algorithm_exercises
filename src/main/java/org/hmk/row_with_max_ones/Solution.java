package org.hmk.row_with_max_ones;

public class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int counts = 0;
            for (int j = 0; j < m; ++j) {
                if (arr[i][j] == 0) {
                    counts++;
                } else {
                    break;
                }
            }
            counts = m - counts;
            if (counts > 0 && counts > max) {
                max = counts;
                index = i;
            }
        }
        return index;
    }
}
