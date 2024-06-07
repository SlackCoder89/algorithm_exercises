package org.hmk.neg_two;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int a = two2Int(arr1);
        int b = two2Int(arr2);
        return int2Two(a + b);
    }

    private int[] int2Two(int num) {
        if (num == -1) {
            return new int[]{1, 1};
        }
        int ord = 0;
        List<Integer> twos = new ArrayList<>();
        while (num != 0) {
            int base = (int)Math.pow(-2, ord);
            int quo = num / base;
            if (quo == 1) {
                num -= quo * base;
                twos.add(quo);
            } else {
                twos.add(0);
            }
            num *= -1;
            ++ord;
        }
        int[] res = new int[twos.size()];
        for (int i = 0; i < twos.size(); ++i) {
            res[i] = twos.get(twos.size() - i - 1);
        }
        if (res.length == 0) {
            res = new int[]{0};
        }
        return res;
    }

    private int two2Int(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; ++i) {
            res += arr[i] * Math.pow(-2, arr.length - i - 1);
        }
        return res;
    }
}
