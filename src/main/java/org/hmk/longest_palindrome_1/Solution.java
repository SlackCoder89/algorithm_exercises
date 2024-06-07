package org.hmk.longest_palindrome_1;

public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; ++i) {
            String tmp = longestPalindrome(s, i - 1, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
            tmp = longestPalindrome(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }

    private String longestPalindrome(String s, int left, int right) {
        int preLeft = -1;
        int preRight = -1;
        String res = "";
        if (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            preLeft = left;
            preRight = right;
        } else {
            return res;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            preLeft = left;
            preRight = right;
            left--;
            right++;
        }
        return s.substring(preLeft, preRight + 1);
    }
}
