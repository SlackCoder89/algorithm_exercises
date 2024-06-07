package org.hmk.rotate_array;

public class Solution {
    static void rotateArr(int arr[], int d, int n) {
        d %= n;
        int[] tmp = new int[d];
        System.arraycopy(arr, 0, tmp, 0, d);
        for (int i = d; i < n; ++i) {
            arr[i - d] = arr[i];
        }
        for (int i = n - d; i < n; ++i) {
            arr[i] = tmp[i - n + d];
        }
    }
}
