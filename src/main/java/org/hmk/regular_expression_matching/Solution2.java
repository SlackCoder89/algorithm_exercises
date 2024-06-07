package org.hmk.regular_expression_matching;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        String[][] inputs = new String[][]{
                {"aa", "a", "false"},
                {"aa", "a*", "true"},
                {"ab", ".*", "true"},
                {"aab", "c*a*b", "true"},
                {"mississippi", "mis*is*ip*.", "true"},
                {"aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*", "true"},
                {"a", "ab*a", "false"},
                {"a", ".*..a*", "false"},
                {"aab", "b.*", "false"}
        };
        Solution2 s = new Solution2();
        for (String[] ss : inputs) {
            boolean actual = s.isMatch(ss[0], ss[1]);
            if (!Boolean.valueOf(ss[2]).equals(actual)) {
                System.out.printf("%s: %s\n", Arrays.toString(ss), s.isMatch(ss[0], ss[1]));
            }
        }
    }

    public boolean isMatch(String s, String p) {
        int[][] cache = new int[s.length() + 1][p.length() + 1];
        cache[0][0] = 2;
        cache[0][1] = 1;
        cache[1][0] = 1;

        return doMatch(s, s.length() - 1, p, p.length() - 1, cache);
    }

    private boolean doMatch(String s, int sIndex, String p, int pIndex, int[][] cache) {
        if (cache[sIndex + 1][pIndex + 1] != 0) {
            return cache[sIndex + 1][pIndex + 1] == 2;
        }

        if (pIndex < 0) {
            cache[sIndex + 1][pIndex + 1] = 1;
            return false;
        }

        if (p.charAt(pIndex) != '*') {
            if (p.charAt(pIndex) == '.' || (sIndex >= 0 && p.charAt(pIndex) == s.charAt(sIndex))) {
                if (sIndex >= 0 && cache[sIndex][pIndex] == 0) {
                    doMatch(s, sIndex - 1, p, pIndex - 1, cache);
                }

                if (sIndex == -1) {
                    cache[sIndex + 1][pIndex + 1] = 1;
                } else {
                    cache[sIndex + 1][pIndex + 1] = cache[sIndex][pIndex];
                }
                return cache[sIndex + 1][pIndex + 1] == 2;
            } else {
                cache[sIndex + 1][pIndex + 1] = 1;
                return false;
            }
        } else {
//            if (sIndex < 0) {
//                return false;
//            }

            if ((sIndex >= 0 && s.charAt(sIndex) == p.charAt(pIndex - 1)) || p.charAt(pIndex - 1) == '.') {
                if (sIndex >= 0 && cache[sIndex][pIndex + 1] == 0) {
                    doMatch(s, sIndex - 1, p, pIndex, cache);
                }

//                if (sIndex == -1) {
//                    cache[sIndex + 1][pIndex + 1] = 2;
//                    return true;
//                }

                if (sIndex >= 0 && cache[sIndex][pIndex + 1] == 2) {
                    cache[sIndex + 1][pIndex + 1] = 2;
                    return true;
                }

                if (cache[sIndex + 1][pIndex - 1] == 0) {
                    doMatch(s, sIndex, p, pIndex - 2, cache);
                }

                if (cache[sIndex + 1][pIndex - 1] == 2) {
                    cache[sIndex + 1][pIndex + 1] = 2;
                    return true;
                }

                cache[sIndex + 1][pIndex + 1] = 1;
                return false;
            } else {
                if (cache[sIndex + 1][pIndex - 1] == 0) {
                    doMatch(s, sIndex, p, pIndex - 2, cache);
                }

                cache[sIndex + 1][pIndex + 1] = cache[sIndex + 1][pIndex - 1];
                return cache[sIndex + 1][pIndex + 1] == 2;
            }
        }
    }
}
