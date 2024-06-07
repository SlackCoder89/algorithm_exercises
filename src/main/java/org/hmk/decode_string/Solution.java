package org.hmk.decode_string;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] inputs = new String[]{
//                "3[a]2[bc]",
//                "3[a2[c]]",
//                "2[abc]3[cd]ef",
//                "abc3[cd]xyz",
                "100[leetcode]"
        };

        Solution solution = new Solution();
        for (String s : inputs) {
            System.out.println(s + ": " + solution.decodeString(s));
        }
    }
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ']') {
                doDecode(stack);
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void doDecode(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            if (c != '[') {
                sb.insert(0, c);
            } else {
                break;
            }
        }

        int count = -1;
        StringBuilder countSb = new StringBuilder();
        while (!stack.isEmpty()) {
            Character c = stack.peek();
            if (c >= '0' && c <= '9') {
                countSb.insert(0, c);
                stack.pop();
            } else {
                break;
            }
        }
        count = Integer.parseInt(countSb.toString());
        for (int i = 0; i < count; ++i) {
            for (int j = 0; j < sb.length(); ++j) {
                stack.push(sb.charAt(j));
            }
        }
    }
}
