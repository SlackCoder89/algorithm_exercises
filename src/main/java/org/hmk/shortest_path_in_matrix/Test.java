package org.hmk.shortest_path_in_matrix;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {
//                {0,1},{1,0}
//        }));

//        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {
//                {0,0,0},{1,1,0},{1,1,0}
//        }));

//        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {
//                {1,0,0},{1,1,0},{1,1,0}
//        }));

//        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {
//                {0,0,0},{1,1,0},{1,1,1}
//        }));

//        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {
//                {0}
//        }));

        System.out.println(solution.shortestPathBinaryMatrix(new int[][] {
                {0,0,0,0,1},{1,0,0,0,0},{0,1,0,1,0},{0,0,0,1,1},{0,0,0,1,0}
        }));
    }
}
