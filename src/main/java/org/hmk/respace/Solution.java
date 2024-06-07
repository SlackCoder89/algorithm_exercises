package org.hmk.respace;

import java.util.Set;

public class Solution {
    String bestSplit(Set<String> dictionary, String sentence, int start) {
        ParseResult r = split(dictionary, sentence, 0);
        return r == null ? null : r.parsed;
    }

    private ParseResult split(Set<String> dictionary, String sentence, int start) {
        if (start >= sentence.length()) {
            return new ParseResult(0, "");
        }

        int bestInvalid = Integer.MAX_VALUE;
        String bestParsing = null;
        String partial = "";
        int index = start;
        while (index < sentence.length()) {
            char c = sentence.charAt(index);
            partial += c;
            int invalid = dictionary.contains(partial) ? 0 : partial.length();
            if (invalid < bestInvalid) {
                ParseResult result = split(dictionary, sentence, index + 1);
                if (invalid + result.invalid < bestInvalid) {
                    bestInvalid = invalid + result.invalid;
                    bestParsing = partial + " " + result.parsed;
                    if (bestInvalid == 0) {
                        break;
                    }
                }
            }

            index++;
        }
        return new ParseResult(bestInvalid, bestParsing);
    }
}

class ParseResult {
    public int invalid = Integer.MAX_VALUE;
    public String parsed = " ";

    public ParseResult(int invalid, String parsed) {
        this.invalid = invalid;
        this.parsed = parsed;
    }
}
