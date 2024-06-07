package org.hmk.next_smallest_palindrome;

import java.util.Arrays;
import java.util.Vector;

public class Solution {
    Vector<Integer> generateNextPalindrome(int[] num, int n) {
        int[] parl1 = transferToPalindrome(num);
        if (Arrays.compare(parl1, num) > 0) {
            return convertToVector(parl1);
        }
        int[] num2 = addOneToMiddle(num);
        int[] par2 = transferToPalindrome(num2);
        return convertToVector(par2);
    }

    private int[] addOneToMiddle(int[] num) {
        int[] res = new int[num.length];
        System.arraycopy(num, 0, res, 0, num.length);
        int middle = 0;
        if (num.length % 2 == 0) {
            middle = num.length / 2 - 1;
        } else {
            middle = num.length / 2;
        }
        int index = middle;
        boolean addition = true;
        while (addition) {
            int sum = res[index] + 1;
            res[index] = sum % 10;
            addition = sum / 10 > 0;
            if (addition && index == 0) {
                int[] tmp = new int[num.length + 1];
                System.arraycopy(res, 0, tmp, 1, tmp.length - 1);
                res = tmp;
                ++index;
            }
            --index;
        }
        return res;
    }

    private Vector<Integer> convertToVector(int[] num) {
        Vector<Integer> v = new Vector<>(num.length);
        for (int n : num) {
            v.add(n);
        }
        return v;
    }

    private int[] transferToPalindrome(int[] num) {
        int[] res = new int[num.length];
        int start;
        if (num.length % 2 == 0) {
            start = num.length / 2;
        } else {
            start = num.length / 2 + 1;
        }
        System.arraycopy(num, 0, res, 0, start);
        for (int i = start; i < num.length; ++i) {
            res[i] = res[res.length - i - 1];
        }
        return res;
    }
}
