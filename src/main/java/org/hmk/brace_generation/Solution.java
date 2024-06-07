package org.hmk.brace_generation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int lc = 0;
        int rc = 0;
        doGenerateParenthesis(n * 2, res, new StringBuilder(), lc, rc);
        return res;
    }

    private void doGenerateParenthesis(int len, List<String> res, StringBuilder buf, int lc, int rc) {
        if (len == buf.length()) {
            res.add(buf.toString());
            return;
        }

        List<String> options = new ArrayList<>();
        if (lc < len / 2) {
            options.add("(");
        }
        if (lc > rc) {
            options.add(")");
        }

        for (String s : options) {
            buf.append(s);
            if (s.equals("(")) {
                doGenerateParenthesis(len, res, buf, lc + 1, rc);
            } else {
                doGenerateParenthesis(len, res, buf, lc, rc + 1);
            }
            buf.deleteCharAt(buf.length() - 1);
        }
    }
}
