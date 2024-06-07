package org.hmk.kth_grammer;

public class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        } else {
            int mod = k % 2;
            int parent = kthGrammar(n - 1, k / 2 + mod);
            if (parent == 1) {
                if (mod  == 1) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (mod == 1) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
    }
}
