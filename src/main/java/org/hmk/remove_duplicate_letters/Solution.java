package org.hmk.remove_duplicate_letters;

import java.util.*;

public class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> letterCounter = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            letterCounter.compute(s.charAt(i), (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }
        Set<Character> exist = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    exist.add(c);
                    break;
                } else {
                    if (exist.contains(c)) {
                        letterCounter.compute(c, (k, v) -> (v - 1));
                        break;
//                    } else if (letterCounter.get(c) == 1) {
//                        stack.push(c);
//                        exist.add(c);
//                        break;
                    } else {
                        char top = stack.peek();
                        if (c > top) {
                            stack.push(c);
                            exist.add(c);
                            break;
                        } else if (c < top) {
                            if (letterCounter.get(top) > 1) {
                                stack.pop();
                                exist.remove(top);
                                letterCounter.compute(top, (k, v) -> v - 1);
                                continue;
                            }
                            stack.push(c);
                            exist.add(c);
                            break;
                        }
                    }
                }
            }
        }
        char[] ret = new char[stack.size()];
        for (int i = ret.length - 1; i >= 0; --i) {
            ret[i] = stack.pop();
        }
        return new String(ret);
    }
}
