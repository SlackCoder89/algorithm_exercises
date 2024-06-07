package org.hmk.num_composition;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    Map<String, List<String>> map = new HashMap<>();
    String[] array = new String[]{
            "2abc",
            "3def",
            "4ghi",
            "5jkl",
            "6mno",
            "7pqrs",
            "8tuv",
            "9wxyz"
    };
    public List<String> letterCombinations(String digits) {
        for (String s : array) {
            map.put(s.substring(0, 1), splitString(s.substring(1)));
        }
        List<String> res = new ArrayList<>();
        doDoCombinations(digits, 0, res, new StringBuilder());
        if (res.size() == 1 && res.get(0).equals("")) {
            return Collections.emptyList();
        }
        return res;
    }

    private void doDoCombinations(String digits, int index, List<String> res, StringBuilder buf) {
        if (index == digits.length()) {
            res.add(buf.toString());
            return;
        }

        List<String> strs = this.map.get(digits.substring(index, index + 1));
        for (String s : strs) {
            buf.append(s);
            doDoCombinations(digits, index + 1, res, buf);
            buf.deleteCharAt(buf.length() - 1);
        }
    }

    private List<String> splitString(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            res.add(s.substring(i, i + 1));
        }
        return res;
    }
}
