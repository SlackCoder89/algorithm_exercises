package org.hmk.word_break;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int wordBreak(int n, String s, ArrayList<String> dictionary ) {
        //code here
        Map<String, Integer> cache = new HashMap<>();
        cache.put("", 1);
        return doWordBreak(s, dictionary, cache);
    }

    private static int doWordBreak(String s, ArrayList<String> dictionary, Map<String, Integer> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        for (String d : dictionary) {
            if (s.startsWith(d)) {
                if (doWordBreak(s.substring(d.length()), dictionary, cache) == 1) {
                    cache.put(s, 1);
                    return 1;
                }
            }
        }
        cache.put(s, 0);
        return 0;
    }
}
