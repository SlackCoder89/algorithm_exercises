package org.hmk.print_anagrams_together;

public class Test {
    public static void main(String[] args) {
        Solution s  = new Solution();
        System.out.println(s.Anagrams(new String[]{
                "act", "god", "cat", "dog", "tac"
        }));
        System.out.println(s.Anagrams(new String[]{
                "no", "on", "is"
        }));
    }
}
