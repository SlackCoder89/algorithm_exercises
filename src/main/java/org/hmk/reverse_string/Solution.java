package org.hmk.reverse_string;

public class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int k = s.length - 1;
        while (i < k) {
            char t = s[i];
            s[i] = s[k];
            s[k] = t;
            ++i;
            --k;
        }
    }
}
