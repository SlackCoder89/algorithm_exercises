package org.hmk.word_break;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(Solution.wordBreak(6, "ilike", buildList(new String[]{
                 "i", "like", "sam", "sung", "samsung", "mobile"
        })));
        System.out.println(Solution.wordBreak(6, "ilikesamsung", buildList(new String[]{
                "i", "like", "sam", "sung", "samsung", "mobile"
        })));
    }

    private static ArrayList<String> buildList(String[] strings) {
        return new ArrayList<>(Arrays.asList(strings));
    }
}
