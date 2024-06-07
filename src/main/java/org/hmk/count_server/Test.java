package org.hmk.count_server;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countServers(new int[][]{
                {1,0},
                {0,1}
        }));
        System.out.println(solution.countServers(new int[][]{
                {1,0},
                {1,1}
        }));
        System.out.println(solution.countServers(new int[][]{
                {1,1,0,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,1}
        }));
    }
}
