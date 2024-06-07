package org.hmk.count_homogenous;

public class Solution {
    public int countHomogenous(String s) {
        final long mod = 1000000007;
        char c = ' ';
        long sum = 0;
        long count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                long tmp = count * (count + 1) / 2;
                tmp %= mod;
                sum += tmp;
                sum %= mod;
                count = 1;
                c = s.charAt(i);
            }
        }
        long tmp = count * (count + 1) / 2;
        tmp %= mod;
        sum += tmp;
        sum %= mod;
        return (int)sum;
    }
}
