package org.hmk.find_pair_given_difference;

import java.util.*;

public class Solution {
    public int findPair(int n, int x, int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            List<Integer> list = Arrays.asList(a + x, a - x);
            map.put(a, list);
            set.add(a);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int num : entry.getValue()) {
                if (set.contains(num)) {
                    return 1;
                }
            }
        }
        return -1;
    }
}
