package org.hmk.first_non_repeating_character_in_a_stream;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String FirstNonRepeating(String s) {
        int[] counts = new int[26];
        List<Character> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            counts[c - 'a']++;
            if (counts[c - 'a'] == 1) {
                list.add(c);
            }

            while (!list.isEmpty()) {
                if (counts[list.get(0) - 'a'] > 1) {
                    list.remove(0);
                } else {
                    break;
                }
            }

            if (list.isEmpty()) {
                sb.append("#");
            } else {
                sb.append(list.get(0));
            }
        }

        return sb.toString();
    }
}
