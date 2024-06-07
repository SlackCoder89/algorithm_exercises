package org.hmk.interval_merge;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(Arrays.deepToString(solution.merge(new int[][]{
//                {1, 3}, {2, 6}, {8, 10}, {15, 18}
//        })));
//        System.out.println(Arrays.deepToString(solution.merge(new int[][]{
//                {1,4},{4,5}
//        })));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{
                {2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}
        })));
    }
}
