package org.hmk.minimum_effort_path;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.minimumEffortPath(new int[][]{
                {1,2,2},{3,8,2},{5,3,5}
        }));
        System.out.println(solution.minimumEffortPath(new int[][]{
                {1,2,3},{3,8,4},{5,3,5}
        }));
        System.out.println(solution.minimumEffortPath(new int[][]{
                {1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}
        }));
    }
}
