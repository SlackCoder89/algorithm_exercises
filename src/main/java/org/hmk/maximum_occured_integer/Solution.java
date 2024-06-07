package org.hmk.maximum_occured_integer;

public class Solution {
    public static int maxOccured(int l[], int r[], int n, int maxx){
        int[] counts = new int[maxx + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = l[i]; j <= r[i]; ++j) {
                counts[j]++;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < maxx; ++i) {
            max = Math.max(counts[i], max);
        }

        for (int i = 0; i < maxx; ++i) {
            if (counts[i] == max) {
                return i;
            }
        }
        return -1;
    }
}
