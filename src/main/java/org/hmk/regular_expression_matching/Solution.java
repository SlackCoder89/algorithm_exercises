package org.hmk.regular_expression_matching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[][] inputs = new String[][]{
                {"aa", "a", "false"},
                {"aa", "a*", "true"},
                {"ab", ".*", "true"},
                {"aab", "c*a*b", "true"},
                {"mississippi", "mis*is*ip*.", "true"},
                {"aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*", "true"},
                {"a", "ab*a", "false"}
        };
        Solution s = new Solution();
        for (String[] ss : inputs) {
            boolean actual = s.isMatch(ss[0], ss[1]);
            if (!Boolean.valueOf(ss[2]).equals(actual)) {
                System.out.printf("%s: %s\n", Arrays.toString(ss), s.isMatch(ss[0], ss[1]));
            }
        }
    }

    Map<Key, Boolean> cache = new HashMap<>();

    public boolean isMatch(String s, String p) {
        if (cache.containsKey(new Key(s, p))) {
            return cache.get(new Key(s, p));
        }

        int i = 0;
        int j = 0;
        char stark = '*';
        char period = '.';
        while (i < s.length() && j < p.length()) {
            if (j + 1 < p.length() && p.charAt(j + 1) == stark) {
                String subP = p.substring(j + 2);
                String subS = s.substring(i);
                if (isMatch(subS, subP)) {
//                    System.out.printf("compare %s, %s: %s\n", s, p, true);
                    cache.put(new Key(s, p), true);
                    return true;
                }
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == period) {
                    ++i;
                    continue;
                }
//                System.out.printf("compare %s, %s: %s\n", s, p, false);
                cache.put(new Key(s, p), false);
                return false;
            }

            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == period) {
                ++i;
                ++j;
            } else {
//                System.out.printf("compare %s, %s: %s\n", s, p, false);
                cache.put(new Key(s, p), false);
                return false;
            }
        }
        while (j + 1 < p.length() && p.charAt(j + 1) == stark) {
            j += 2;
        }
        if (i == s.length() && j == p.length()) {
//            System.out.printf("compare %s, %s: %s\n", s, p, true);
            cache.put(new Key(s, p), true);
            return true;
        }
//        if ((j == p.length() - 2 || j == p.length() - 3) && p.charAt(j + 1) == stark) {
//            System.out.printf("compare %s, %s: %s\n", s, p, true);
//            return true;
//        }
//        System.out.printf("compare %s, %s: %s\n", s, p, false);
        cache.put(new Key(s, p), false);
        return false;
    }
}

class Key {
    String s1;
    String s2;

    public Key(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Key key = (Key) o;

        if (!s1.equals(key.s1)) return false;
        return s2.equals(key.s2);
    }

    @Override
    public int hashCode() {
        int result = s1.hashCode();
        result = 31 * result + s2.hashCode();
        return result;
    }
}