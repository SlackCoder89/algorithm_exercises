package org.hmk.reachable_at_time;

public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy && t == 1) {
            return false;
        }
        int ax = Math.abs(sx - fx);
        int ay = Math.abs(sy - fy);
        return Math.max(ax, ay) <= t;
    }
}
