package org.hmk.maximum_occured_integer;

public class Test {
    public static void main(String[] args) {
        System.out.println(Solution.maxOccured(new int[]{
                1,4,3,1
        }, new int[]{
                15,8,5,4
        }, 4, 15));

        System.out.println(Solution.maxOccured(new int[]{
                1,5,9,13,21
        }, new int[]{
                15,8,12,20,30
        }, 5, 30));
    }
}
