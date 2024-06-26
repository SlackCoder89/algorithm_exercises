package org.hmk.integer_break;

public class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int product = 1;
        while (n >= 5) {
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }
}
