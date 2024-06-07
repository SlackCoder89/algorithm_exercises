package org.hmk.num_max;

public class Test {
    public static void main(String[] args) {
        System.out.println(negate(1));
    }

    public static int negate(int a) {
        return a - Integer.MAX_VALUE;
    }
}
