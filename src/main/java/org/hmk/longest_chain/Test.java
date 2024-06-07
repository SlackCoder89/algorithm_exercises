package org.hmk.longest_chain;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findLongestChain(new int[][]{
                {1,2},{2,3},{3,4}
        }));
        System.out.println(solution.findLongestChain(new int[][]{
                {1,2},{7,8},{4,5}
        }));
    }
}
