package org.hmk.anagram_of_string;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int remAnagrams(String s,String s1)
    {
        // find long string
        String longStr;
        String shortStr;
        if (s.length() > s1.length()) {
            longStr = s;
            shortStr = s1;
        } else {
            longStr = s1;
            shortStr = s;
        }

        // count number of letters in long string
        Map<Character, Integer> cMap = new HashMap<>();
        for (int i = 0; i < longStr.length(); ++i) {
            if (cMap.containsKey(longStr.charAt(i))) {
                cMap.put(longStr.charAt(i), cMap.get(longStr.charAt(i)) + 1);
            } else {
                cMap.put(longStr.charAt(i), 1);
            }
        }

        // count letters need to be deleted in short string
        int numberOfLetterToBeDeleted = 0;
        for (int i = 0; i < shortStr.length(); ++i) {
            if (cMap.containsKey(shortStr.charAt(i))) {
                int left = cMap.get(shortStr.charAt(i)) - 1;
                if (left == 0) {
                    cMap.remove(shortStr.charAt(i));
                } else {
                    cMap.put(shortStr.charAt(i), left);
                }
            } else {
                numberOfLetterToBeDeleted++;
            }
        }

        // count letters need to be deleted in long string
        for (Map.Entry<Character, Integer> entry : cMap.entrySet()) {
            numberOfLetterToBeDeleted += entry.getValue();
        }

        return numberOfLetterToBeDeleted;
    }
}
