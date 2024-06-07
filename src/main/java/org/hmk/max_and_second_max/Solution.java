package org.hmk.max_and_second_max;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]) {
        int max = -1;
        int secMax = -1;
        for (int n : arr) {
            max = Math.max(max, n);
        }
        for (int n : arr) {
            if (n < max) {
                secMax = Math.max(n, secMax);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(max);
        res.add(secMax);
        return res;
    }
}
