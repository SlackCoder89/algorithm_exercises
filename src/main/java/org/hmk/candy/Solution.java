package org.hmk.candy;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] inputs = new int[][]{
//                {1,0,2},
//                {1,2,2},
                {1,3,2,2,1},
//                {29,51,87,87,72,12}
        };
        Solution solution = new Solution();
        for (int[] input : inputs) {
            System.out.println(Arrays.toString(input) + ": " + solution.candy(input));
        }
    }
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }
}
