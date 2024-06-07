package org.hmk.neg_two;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{
//                1, 1, 1, 1, 1
//        }, new int[]{
//                1, 0, 1
//        })));

//        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{
//                0
//        }, new int[]{
//                0
//        })));

//        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{
//                0
//        }, new int[]{
//                1
//        })));

//        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{
//                0
//        }, new int[]{
//                1, 1
//        })));

        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{
                0
        }, new int[]{
                1, 0, 1
        })));
    }
}
