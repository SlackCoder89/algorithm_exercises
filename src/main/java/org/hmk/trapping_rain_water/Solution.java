package org.hmk.trapping_rain_water;

public class Solution {
    static long trappingWater(int arr[], int n) {
        long sum = 0;
        for (int i = 0; i < n - 2;) {
            if (arr[i] <= arr[i + 1]) {
                ++i;
                continue;
            }
            int index = i + 1;
            for (int j = index + 1; j < n; ++j) {
                if (arr[j] > arr[index]) {
                    index = j;
                }
                if (arr[index] > arr[i]) {
                    break;
                }
            }
            if (index == i + 1) {
                ++i;
                continue;
            }
            sum += calculate(arr, i, index);
            i = index;
        }
        return sum;
    }

    private static long calculate(int[] arr, int start, int end) {
        int height = Math.min(arr[start], arr[end]);
        long sum = 0;
        for (int i = start + 1; i < end; ++i) {
            if (height < arr[i]) {
                continue;
            }
            sum += height - arr[i];
        }
        return sum;
    }
}
