package org.hmk.rotate_array;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        Solution.rotateArr(arr, 3, 10);
        System.out.println(Arrays.toString(arr));
    }
}
