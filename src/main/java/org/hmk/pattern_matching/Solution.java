package org.hmk.pattern_matching;

public class Solution {
    boolean doesMatch(String pattern, String value) {
        if (pattern.length() == 0) {
            return value.length() == 0;
        }

        int size = value.length();
        for (int mainSize = 0; mainSize < size; mainSize++) {
            String main = value.substring(0, mainSize);
            for (int altStart = mainSize; altStart <= size; altStart++) {
                for (int altEnd = altStart; altEnd <= size; ++altEnd) {
                    String alt = value.substring(altStart, altEnd);
                    String cand = buildFromPattern(pattern, main, alt);
                    if (cand.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String buildFromPattern(String pattern, String main, String alt) {
        return "";
    }
}
