package org.hmk.min_deletions;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> cMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            cMap.put(s.charAt(i), cMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Integer, Integer> iMap = new HashMap<>();
        for (int i : cMap.values()) {
            iMap.put(i, iMap.getOrDefault(i, 0) + 1);
        }
        Map<Integer, Integer> icMap = new HashMap<>(iMap);
        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : iMap.entrySet()) {
            if (entry.getValue() >= 2) {
                ret += deleteKey(entry.getKey(), entry.getValue(), icMap);
            }
        }
        return ret;
    }

    private int deleteKey(Integer i, Integer count, Map<Integer, Integer> icMap) {
        int ret = 0;
        while (count > 1) {
            int ic = i;
            while (icMap.containsKey(ic)) {
                if (ic <= 0) {
                    break;
                }
                --ic;
                ret++;
            }
            if (ic > 0) {
                icMap.put(ic, 1);
            }
            count--;
        }
        return ret;
    }
}
