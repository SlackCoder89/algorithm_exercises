package org.hmk.pizza_love;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxPizza(2, new int[]{
                1, 2, 3, 4, 5
        }));
        System.out.println(s.maxPizza(2, new int[]{
                5, 3, 4, 11, 2
        }));
    }
}
