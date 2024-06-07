package org.hmk.last_moment;

public class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = Integer.MIN_VALUE;
        for (int o : left) {
            max = Math.max(max, o);
        }
        for (int o : right) {
            max = Math.max(max, n - o);
        }
        return max;
    }
}
