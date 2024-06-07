package org.hmk.find_median_in_a_stream;

public class Test {
    public static void main(String[] args) {
//        testSolution(new int[]{
//                5,15,1,3
//        });
        testSolution(new int[]{
                5,10,15
        });
    }

    private static void testSolution(int[] ints) {
        for (int i : ints) {
            Solution.insertHeap(i);
            System.out.println(Solution.getMedian());
        }
    }
}
