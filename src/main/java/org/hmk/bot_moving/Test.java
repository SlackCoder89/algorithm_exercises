package org.hmk.bot_moving;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.sumDistance(new int[]{
//                -2,0,2
//        }, "RLL", 3));

//        System.out.println(solution.sumDistance(new int[]{
//                1,0
//        }, "RL", 2));

        System.out.println(solution.sumDistance(new int[]{
                -10,-13,10,14,11
        }, "LRLLR", 2));
    }
}
