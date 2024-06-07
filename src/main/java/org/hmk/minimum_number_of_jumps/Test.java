package org.hmk.minimum_number_of_jumps;

public class Test {
    public static void main(String[] args) {
        System.out.println(Solution.minJumps(new int[]{
                1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9
        }));
        System.out.println(Solution.minJumps(new int[]{
                1, 4, 3, 2, 6, 7
        }));
    }
}
