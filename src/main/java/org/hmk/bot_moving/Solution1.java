package org.hmk.bot_moving;

import java.util.Arrays;

public class Solution1 {
    static final int MOD = 1000000007;

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = (long) nums[i] - d;
            } else {
                pos[i] = (long) nums[i] + d;
            }
        }
        Arrays.sort(pos);
        long sum = 0;
        long mod = 1000000000 + 7;
        for (int i = 1; i < n; i++) {
            long distance = pos[i] - pos[i - 1];
            distance %= mod;
            distance *= i;
            distance %= mod;
            distance *= n - i;
            distance %= mod;
            sum += distance;
            sum %= mod;
        }
        return (int) sum;
    }
}
