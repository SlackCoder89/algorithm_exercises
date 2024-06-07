package org.hmk.min_extra_char;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int min = s.length();
        Map<String, Integer> cache = new HashMap<>();
        return doMinExtraChar(s, dictionary, cache);
    }

    private int doMinExtraChar(String s, String[] dictionary, Map<String, Integer> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        int min = s.length();
        for (String word : dictionary) {
            if (s.contains(word)) {
                String[] subs = splitStr(s, word);
                int tmp = doMinExtraChar(subs[0], dictionary, cache) + doMinExtraChar(subs[1], dictionary, cache);
                min = Math.min(tmp, min);
            }
        }
        cache.put(s, min);
        return min;
    }

    private String[] splitStr(String s, String word) {
        int index = s.indexOf(word);
        return new String[]{s.substring(0, index), s.substring(index + word.length())};
    }
}
