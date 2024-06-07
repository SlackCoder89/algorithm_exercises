package org.hmk.unique_binary_search_trees;

public class Solution {
    public static void main(String[] args) {
        int[] inputs = new int[]{
                3,
                1
        };
        Solution solution = new Solution();
        for (int i : inputs) {
            System.out.println(i + ": " + solution.numTrees(i));
        }
    }

    public int numTrees(int n) {
        int[][] mem = new int[n + 1][n + 1];
        doNumTrees(1, n, mem);
        return mem[1][n];
    }

    private int doNumTrees(int start, int end, int[][] mem) {
        if (start > end) {
            return 1;
        }
        if (mem[start][end] > 0) {
            return mem[start][end];
        }

        if (start == end) {
            mem[start][end] = 1;
            return 1;
        }

        int count = 0;
        for (int i = start; i <= end; ++i) {
            int left = doNumTrees(start, i - 1, mem);
            int right = doNumTrees(i + 1, end, mem);
            count += left * right;
        }
        mem[start][end] = count;
        return count;
    }
}