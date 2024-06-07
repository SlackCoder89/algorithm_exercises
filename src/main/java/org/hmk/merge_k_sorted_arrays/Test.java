package org.hmk.merge_k_sorted_arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(Solution.mergeKArrays(new int[][]{
                {1,2,3},{4,5,6},{7,8,9},
        }, 3));
        System.out.println(Solution.mergeKArrays(new int[][]{
                {1,2,3,4},{2,2,3,4},
                {5,5,6,6},{7,8,9,9}
        }, 4));
    }
}
