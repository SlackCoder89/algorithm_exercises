package org.hmk.row_with_max_ones;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rowWithMax1s(new int[][]{
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        }, 4, 4));
        System.out.println(solution.rowWithMax1s(new int[][]{
                {0, 0}, {1, 1}
        }, 2, 2));
        System.out.println(solution.rowWithMax1s(new int[][]{
                {0, 0}, {0, 0}
        }, 2, 2));
    }
}
