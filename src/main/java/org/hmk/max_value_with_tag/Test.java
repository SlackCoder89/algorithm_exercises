package org.hmk.max_value_with_tag;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.largestValsFromLabels(new int[]{
//                5,4,3,2,1
//        }, new int[]{
//                1,1,2,2,3
//        }, 3, 1));

//        System.out.println(solution.largestValsFromLabels(new int[]{
//                5,4,3,2,1
//        }, new int[]{
//                1,3,3,3,2
//        }, 3, 2));

        System.out.println(solution.largestValsFromLabels(new int[]{
                9,8,8,7,6
        }, new int[]{
                0,0,0,1,1
        }, 3, 1));
    }
}
