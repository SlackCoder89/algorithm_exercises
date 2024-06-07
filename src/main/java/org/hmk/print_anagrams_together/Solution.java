package org.hmk.print_anagrams_together;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        List<AnagramList> list = new ArrayList<>();
        for (String s : string_list) {
            addToList(list, s);
        }

        List<List<String>> res = new ArrayList<>();
        for (AnagramList a : list) {
            res.add(a.strings);
        }
        return res;

    }

    private void addToList(List<AnagramList> list, String s) {
        Anagram a = new Anagram(s);
        for (AnagramList al : list) {
            if (al.anagram.equals(a)) {
                al.strings.add(s);
                return;
            }
        }
        List<String> slist = new ArrayList<>();
        slist.add(s);
        list.add(new AnagramList(a, slist));
    }
}

class AnagramList {
    Anagram anagram;
    List<String> strings;

    public AnagramList(Anagram anagram, List<String> strings) {
        this.anagram = anagram;
        this.strings = strings;
    }
}

class Anagram {
    Map<Character, Integer> map;
    int length;

    public Anagram(Map<Character, Integer> map, int length) {
        this.map = map;
        this.length = length;
    }

    public Anagram(String s) {
        this.length = s.length();
        this.map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.compute(c, (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }
    }

    public boolean equals(Anagram a) {
        if (this.length != a.length) {
            return false;
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (a.map.containsKey(e.getKey()) && a.map.get(e.getKey()).equals(e.getValue())) {
            } else {
                return false;
            }
        }
        return true;
    }
}
