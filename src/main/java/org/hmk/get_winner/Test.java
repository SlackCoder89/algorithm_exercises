package org.hmk.get_winner;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.getWinner(new int[]{2,1,3,5,4,6,7}, 2));
//        System.out.println(solution.getWinner(new int[]{3,2,1}, 10));
        System.out.println(solution.getWinner(new int[]{1,11,22,33,44,55,66,77,88,99}, 1000000000));
    }
}
