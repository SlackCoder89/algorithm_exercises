package org.hmk.smallest_k;

import java.util.Random;

public class Solution {
    int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }
        int threshold = rank(array, k - 1);
        int[] smallest = new int[k];
        int count = 0;
        for (int a : array) {
            if (a <= threshold) {
                smallest[count] = a;
                count++;
            }
        }
        return smallest;
    }

    private int rank(int[] array, int rank) {
        return rank(array, 0, array.length - 1, rank);
    }

    private int rank(int[] array, int left, int right, int rank) {
        int pivot = array[randomIntInRange(left, right)];
        int leftEnd = partion(array, left, right, pivot);
        int leftSize = leftEnd - left + 1;
        if (rank == leftSize - 1) {
            return max(array, left, leftEnd);
        } else if (rank < leftSize) {
            return rank(array, left, leftEnd, rank);
        } else {
            return rank(array, leftEnd + 1, right, rank - leftSize);
        }
    }

    private int max(int[] array, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; ++i) {
            max = Math.max(array[i], max);
        }
        return max;
    }

    private int partion(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            if (array[left] > pivot) {
                swap(array, left, right);
                right--;
            } else if (array[right] <= pivot) {
                swap(array, left, right);
                left++;
            } else {
                left++;
                right--;
            }
        }
        return left - 1;
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private int randomIntInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max + 1 - min) + min;
    }
}
