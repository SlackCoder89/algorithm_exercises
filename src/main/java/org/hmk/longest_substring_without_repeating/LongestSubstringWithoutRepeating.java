package org.hmk.longest_substring_without_repeating;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String[] sa = new String[]{"abcabcbb", "bbbbb", "pwwkew"};
        for (String s : sa) {
            System.out.println(s + " length: " + lengthOfLongestSubstring(s));
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Set<Character> has = new HashSet<>();
        int length = 0;
        int preIndex = 0;
        int endIndex = 0;
        for (; preIndex < s.length(); ) {
            char pre = s.charAt(preIndex);
            if (has.contains(pre)) {
                has.remove(pre);
                length--;
                preIndex++;
            }
            for (; endIndex < s.length(); ++endIndex) {
                char c = s.charAt(endIndex);
                if (has.contains(c)) {
                   break;
                } else {
                    has.add(c);
                    ++length;
                }
            }
            longest = Math.max(length, longest);
        }
        return longest;
    }
}
