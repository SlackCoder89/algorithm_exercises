package org.hmk.pizza_love;

public class Solution {
    int maxPizza(int n, int[] arr) {
        int[] cache = new int[arr.length];
        return doMaxPizza(arr, 0, cache);
    }

    private int doMaxPizza(int[] arr, int index, int[] cache) {
        if (index >= arr.length) {
            return 0;
        }

        if (cache[index] != 0) {
            return cache[index];
        }

        int include = arr[index] + doMaxPizza(arr, index + 2, cache);
        int exclude = doMaxPizza(arr, index + 1, cache);
        int res = Math.max(include, exclude);
        cache[index] = res;
        return res;
    }
}
