package org.hmk.find_duplicates_in_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        Arrays.sort(arr);
        Set<Integer> cache = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < n; ++i) {
            if (arr[i] == arr[i - 1] && !cache.contains(arr[i])) {
                res.add(arr[i]);
                cache.add(arr[i]);
            }
        }
        if (res.isEmpty()) {
            res.add(-1);
        }
        return res;
    }
}
