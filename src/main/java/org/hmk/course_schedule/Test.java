package org.hmk.course_schedule;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
//        System.out.println(Arrays.toString(s.findOrder(2,
//                new int[][]{
//                        {1, 0}
//                })));
        System.out.println(Arrays.toString(s.findOrder(4,
                new int[][]{
                        {1,0},{2,0},{3,1},{3,2}
                })));

//        System.out.println(Arrays.toString(s.findOrder(1,
//                new int[][]{
//                })));
//        System.out.println(Arrays.toString(s.findOrder(2,
//                new int[][]{
//                })));
//
//        System.out.println(Arrays.toString(s.findOrder(2,
//                new int[][]{
//                        {0,1},{1,0}
//                })));
    }
}
