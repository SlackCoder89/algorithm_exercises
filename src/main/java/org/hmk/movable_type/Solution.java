package org.hmk.movable_type;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int numTilePossibilities(String tiles) {
        int count = 0;
        for (int i = 1; i <= tiles.length(); ++i) {
            Set<String> set = print(tiles, i);
            count += set.size();
        }
        return count;
    }

    private Set<String> print(String str, int len) {
        if (len == 0) {
            return new HashSet<>(List.of(""));
        }
        if (str.isEmpty()) {
            return Collections.emptySet();
        } else if (str.length() == 1) {
            return new HashSet<>(List.of(str));
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < str.length(); ++i) {
            String c = String.valueOf(str.charAt(i));
            String sub = str.substring(0, i) + str.substring(i + 1);
            Set<String> subStrs = print(sub, len - 1);
            for (String subStr : subStrs) {
                res.add(c + subStr);
            }
        }
        return res;
    }
}
