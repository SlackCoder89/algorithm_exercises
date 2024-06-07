package org.hmk.maximum_of_all_subarrays_of_size_k;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        Deque<Integer> de = new LinkedList<>();
        extracted(arr, 0, k, de);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n - k; ++i) {
            while (!de.isEmpty() && de.peek() < i) {
                de.poll();
            }
            res.add(arr[de.peek()]);
            if (i + k < n) {
                add(arr, de, i + k);
            }
        }
        return res;
    }

    private static void extracted(int[] arr, int start, int end, Deque<Integer> de) {
        for (int i = start; i < end; ++i) {
            add(arr, de, i);
        }
    }

    private static void add(int[] arr, Deque<Integer> de, int i) {
        if (de.isEmpty() || arr[de.peekLast()] > arr[i]) {
            de.offer(i);
        } else {
            while (!de.isEmpty() && arr[de.peekLast()] <= arr[i]) {
                de.pollLast();
            }
            de.offer(i);
        }
    }
}