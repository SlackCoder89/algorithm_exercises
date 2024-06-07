package org.hmk.find_unsorted_sequence;

public class Solution {
    void findUnsortedSequence(int[] array) {
        int endLeft = findEndOfLeftSubsequence(array);
        if (endLeft >= array.length - 1) {
            return;
        }

        int startRight = findStartOfRightSubsequence(array);

        int maxIndex = endLeft;
        int minIndex = startRight;
        for (int i = endLeft + 1; i < startRight; ++i) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }

        int leftIndex = shrinkLeft(array, minIndex, endLeft);
        int rightIndex = shrinkRight(array, maxIndex, startRight);
    }

    private int shrinkRight(int[] array, int maxIndex, int startRight) {
        return 0;
    }

    private int shrinkLeft(int[] array, int minIndex, int endLeft) {
        return 0;
    }

    private int findStartOfRightSubsequence(int[] array) {
        return 0;
    }

    private int findEndOfLeftSubsequence(int[] array) {
        return 0;
    }
}
