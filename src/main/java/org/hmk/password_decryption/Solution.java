package org.hmk.password_decryption;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    boolean valid(String p,String s) {
        if (s.length() < p.length()) {
            return false;
        }
        Map<Character, Integer> pMap = parseStr(p);
        Map<Character, Integer> sMap = parseStr(s.substring(0, p.length()));
        if (isSame(sMap, pMap)) {
            return true;
        }
        for (int i = 1; i + p.length() <= s.length(); ++i) {
            sMap.compute(s.charAt( i - 1), (k, v) -> v - 1);
            sMap.compute(s.charAt(i + p.length() - 1), (k, v) -> v == null ? 1 : v + 1);
            if (isSame(sMap, pMap)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        for (Map.Entry<Character, Integer> e : pMap.entrySet()) {
            if (!e.getValue().equals(sMap.get(e.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> parseStr(String p) {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < p.length(); ++i) {
            res.compute(p.charAt(i), (character, integer) -> {
                if (integer == null) {
                    return 1;
                } else {
                    return integer + 1;
                }
            });
        }
        return res;
    }
}
