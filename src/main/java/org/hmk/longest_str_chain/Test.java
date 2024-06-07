package org.hmk.longest_str_chain;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(solution.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println(solution.longestStrChain(new String[]{"abcd","dbqca"}));
    }
}
