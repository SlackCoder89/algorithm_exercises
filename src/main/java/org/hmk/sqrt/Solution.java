package org.hmk.sqrt;

public class Solution {
    public int count;
    public int sqrt(int n) {
        count = 0;
        return sqrtHelper(n, 1, n);
    }

    public int sqrtHelper(int n, int min, int max) {
        count++;
        if (min > max) {
            return -1;
        }
        int guess = (min + max) / 2;
        if (guess * guess == n) {
            return guess;
        } else if (guess * guess > n) {
            return sqrtHelper(n, min, guess);
        } else {
            return sqrtHelper(n, guess, max);
        }
    }
}
