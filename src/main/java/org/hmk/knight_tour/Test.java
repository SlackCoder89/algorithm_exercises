package org.hmk.knight_tour;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.checkValidGrid(new int[][]{
//                {0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}
//        }));
//        System.out.println(s.checkValidGrid(new int[][]{
//                {0,3,6},{5,8,1},{2,7,4}
//        }));
//        System.out.println(s.checkValidGrid(new int[][]{
//                {8,3,6},{5,0,1},{2,7,4}
//        }));
        System.out.println(s.checkValidGrid(new int[][]{
                {24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}
        }));
    }
}