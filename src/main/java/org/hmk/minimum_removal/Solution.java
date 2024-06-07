package org.hmk.minimum_removal;

import java.util.Arrays;

public class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);

        long minimum = Long.MAX_VALUE;
        long[] miniArray = new long[beans.length];
        for (int i = 0; i < beans.length; ++i) {
            if (i == 0) {
                miniArray[i] = doMinimumRemoval(i, beans);
            } else {
                miniArray[i] = miniArray[i - 1] - (long) (beans[i] - beans[i - 1]) * (beans.length - i) + beans[i - 1];
            }
            minimum = Math.min(miniArray[i], minimum);
        }
        return minimum;
    }

    private long doMinimumRemoval(int index, int[] beans) {
        long sum = 0;
        int mini = beans[index];
        for (; index < beans.length; ++index) {
            sum += beans[index] - mini;
        }
        return sum;
    }
}
