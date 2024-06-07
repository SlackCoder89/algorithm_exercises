package org.hmk.longest_palindrome;

public class LongestPalindrome {
    public static void main(String[] args) {
        String[] sa = new String[]{"aba", "babad", "cbbd", "aacabdkacaa"};
//        String[] sa = new String[]{"aba"};
        for (String s : sa) {
            System.out.println(s + ": " + longestPalindrome(s));
        }
    }

    public static String longestPalindrome(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); ++i) {
            isPal[i][i] = true;
        }
        for (int i = 0; i < s.length(); ++i) {
            int end  = i + 1;
            if (end >= s.length()) {
                break;
            }
            if (s.charAt(i) == s.charAt(end)) {
                isPal[i][end] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int length = 3; length <= s.length(); ++length) {
            for (int i = 0; i < s.length(); ++i) {
                int end = i + length - 1;
                if (end >= s.length()) {
                    break;
                }
                if (s.charAt(i) == s.charAt(end) && isPal[i + 1][end - 1]) {
                    isPal[i][end] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    private static void decidePalindrome(String s, int index, int[][] isPal) {
        for (int i = 0; index + i < s.length() && index - i > -1; ++i) {
            int start = index - i;
            int end = index + i;
            if (isPal[start][end + 1] != 0) {
                continue;
            }
            if (s.charAt(start) == s.charAt(end) && isPal[start + 1][end] == 2) {
                isPal[start][end + 1] = 2;
            } else {
                isPal[start][end + 1] = 1;
            }
        }

        int initStart = index;
        int initEnd = index + 1;
        for (int i = 0; initStart - i > -1 && initEnd + i < s.length(); ++i) {
            int start = initStart - i;
            int end = initEnd + i;
            if (isPal[start][end + 1] != 0) {
                continue;
            }
            if (s.charAt(start) == s.charAt(end) && isPal[start + 1][end] == 2) {
                isPal[start][end + 1] = 2;
            } else {
                isPal[start][end + 1] = 1;
            }
        }
    }

    private static void decidePalindrome(String s, int i, int j, int[][] isPal) {
        if (s.charAt(i) != s.charAt(j - 1)) {
            isPal[i][j] = 1;
            return;
        }

        if (isPal[i + 1][j - 1] == 0) {
            decidePalindrome(s, i + 1, j - 1, isPal);
        }

        if (isPal[i + 1][j - 1] == 1) {
            isPal[i][j] = 1;
            return;
        }

        if (isPal[i + 1][j - 1] == 2) {
            isPal[i][j] = 2;
            return;
        }

        throw new RuntimeException("impossible");
    }

    private static PalRes findLongestPalindrome(String s, int pre, int end, int[][] isPal) {
        if (isPal[pre][end] == 2) {
            return new PalRes(s, true);
        }
        if (s == null || s.length() == 0) {
            return new PalRes("", true);
        }
        if (s.length() == 1) {
            return new PalRes(s, true);
        }

        PalRes subPreRes = findLongestPalindrome(s.substring(0, s.length() - 1), 0, s.length() - 1, isPal);
        String subPre = subPreRes.pal;
        isPal[0][s.length() - 1] = subPreRes.isPal ? 2 : 1;

        String subMid = "";
        if (s.charAt(0) == s.charAt(s.length() - 1) && isPal[1][s.length() - 1] == 2) {
            subMid = s;
            isPal[0][s.length()] = 2;
        }

        PalRes sufSubRes = findLongestPalindrome(s.substring(1), 1, s.length(), isPal);
        String sufSub = sufSubRes.pal;
        isPal[1][s.length()] = sufSubRes.isPal ? 2 : 1;


        String res = subPre.length() > sufSub.length() ? subPre : sufSub;
        res = res.length() > subMid.length() ? res : subMid;
        return new PalRes(res, res.length() == s.length());
    }

    static class PalRes {
        String pal;
        boolean isPal;

        public PalRes(String pal, boolean isPal) {
            this.pal = pal;
            this.isPal = isPal;
        }
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
