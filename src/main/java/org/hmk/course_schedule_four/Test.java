package org.hmk.course_schedule_four;

public class Test {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        System.out.println(solution.checkIfPrerequisite(2, new int[][]{
//                {1, 0}
//        }, new int[][] {
//                {0, 1},
//                {1, 0}
//        }));
//        System.out.println(solution.checkIfPrerequisite(2, new int[][]{
//        }, new int[][] {
//                {0, 1},
//                {1, 0}
//        }));
//        System.out.println(solution.checkIfPrerequisite(3, new int[][]{
//                {1, 2},
//                {1, 0},
//                {2, 0}
//        }, new int[][] {
//                {1, 0},
//                {1, 2}
//        }));
        System.out.println(solution.checkIfPrerequisite(5, new int[][]{
                {4,3},{4,1},{4,0},{3,2},{3,1},{3,0},{2,1},{2,0},{1,0}
        }, new int[][] {
                {1,4},{4,2},{0,1},{4,0},{0,2},{1,3},{0,1}
        }));
    }
}
