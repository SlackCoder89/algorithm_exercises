package org.hmk.last_moment;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getLastMoment(4, new int[]{4,3}, new int[]{0,1}));
        System.out.println(solution.getLastMoment(7, new int[]{}, new int[]{0,1,2,3,4,5,6,7}));
        System.out.println(solution.getLastMoment(7, new int[]{0,1,2,3,4,5,6,7}, new int[]{}));
    }
}
