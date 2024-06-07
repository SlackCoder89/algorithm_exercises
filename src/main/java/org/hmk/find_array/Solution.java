package org.hmk.find_array;

public class Solution {
    public int[] findArray(int[] pref) {
        if (pref == null || pref.length < 1) {
            return new int[0];
        }
        int[] res = new int[pref.length];
        res[0] = pref[0];
        for (int i = 1; i < res.length; ++i) {
            res[i] = pref[i - 1] ^ pref[i];
        }
        return res;
    }
}
