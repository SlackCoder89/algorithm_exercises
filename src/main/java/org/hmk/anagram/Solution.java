package org.hmk.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[][] input = new String[][]{
                {"anagram", "nagaram"},
                {"rat", "car"}
        };

        Solution s = new Solution();
        for (String[] ss : input) {
            System.out.println(Arrays.toString(ss) + ": " + s.isAnagram(ss[0], ss[1]));
        }
    }

    public boolean isAnagram(String s, String t) {
        char[] characters = s.toCharArray();
        StringBuilder sbSecond = new StringBuilder(t);

        for(char ch : characters){
            int index = sbSecond.indexOf("" + ch);
            if(index != -1){
                sbSecond.deleteCharAt(index);
            }else{
                return false;
            }
        }

        return sbSecond.isEmpty();
    }

    private Map<Character, Integer> extractChar(String s) {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (res.containsKey(c)) {
                res.compute(c, (k, count) -> count + 1);
            } else {
                res.put(c, 1);
            }
        }
        return res;
    }
}
