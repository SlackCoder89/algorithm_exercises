package org.hmk.merge_k_sorted_arrays;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        int[] indexes = new int[k];
        int count = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (count < k * k) {
            int tmp = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < k; ++i) {
                if (indexes[i] >= k) {
                    continue;
                }
                if (arr[i][indexes[i]] < tmp) {
                    tmp = arr[i][indexes[i]];
                    index = i;
                }
            }
            indexes[index]++;
            res.add(tmp);
            count++;
        }
        return res;
    }
}
