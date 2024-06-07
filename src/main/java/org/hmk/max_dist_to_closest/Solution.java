package org.hmk.max_dist_to_closest;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = Integer.MIN_VALUE;
        int prev = 0;
        boolean first = true;
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                if (first) {
                    max = Math.max(max, i - prev);
                    first = false;
                } else {
                    max = Math.max(max, (i - prev) / 2);
                }
                prev = i;
            }
        }
        max = Math.max(max, seats.length - 1 - prev);
        return max;
    }
}
