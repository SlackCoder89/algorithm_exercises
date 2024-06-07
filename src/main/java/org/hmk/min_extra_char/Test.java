package org.hmk.min_extra_char;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.minExtraChar("leetscode", new String[]{
                "leet","code","leetcode"
        }));
        System.out.println(solution.minExtraChar("sayhelloworld", new String[]{
                "hello","world"
        }));
    }
}
