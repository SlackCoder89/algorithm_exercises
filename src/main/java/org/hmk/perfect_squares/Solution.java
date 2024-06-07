package org.hmk.perfect_squares;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] inputs = new int[]{
                12,
                13
        };
        Solution solution = new Solution();
        for (int n : inputs) {
            System.out.println(n + ": "  + solution.numSquares(n));
        }
    }

    public int numSquares(int n) {
        List<Integer> candidates = generateCandidates(n);
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        mem[0] = 0;
        for (Integer c : candidates) {
            mem[c] = 1;
        }
        doNumSquares(n, candidates, mem);
        return mem[n];
    }

    private int doNumSquares(int n, List<Integer> candidates, int[] mem) {
        if (mem[n] != -1) {
            return mem[n];
        }

        int min = Integer.MAX_VALUE;
        for (Integer c : candidates) {
            if (c < n) {
                min = Math.min(min, doNumSquares(n - c, candidates, mem));
            }
        }
        int res = min + 1;
        mem[n] = res;
        return res;
    }

    private List<Integer> generateCandidates(int n) {
        int max = BigDecimal.valueOf(Math.sqrt(n)).intValue();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= max; ++i) {
            res.add(i * i);
        }
        return res;
    }
}
