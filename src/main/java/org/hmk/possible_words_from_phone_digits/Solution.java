package org.hmk.possible_words_from_phone_digits;

import java.util.*;

public class Solution {
    static Map<Integer, List<Character>> map = new HashMap<>();
    static ArrayList<String> possibleWords(int a[], int n) {
        // your code here
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        ArrayList<String> res = new ArrayList<>();
        search(a, 0, new StringBuilder(), res);
        return res;
    }

    private static void search(int[] a, int index, StringBuilder sb, ArrayList<String> res) {
        if (index == a.length) {
            res.add(sb.toString());
            return;
        }

        List<Character> cl = map.getOrDefault(a[index], new ArrayList<>());
        for (Character c : cl) {
            sb.append(c);
            search(a, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
