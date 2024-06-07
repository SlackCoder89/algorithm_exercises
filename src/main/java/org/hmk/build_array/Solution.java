package org.hmk.build_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        final String PUSH = "Push";
        final String POP = "Pop";
        int preIndex = -1;
        int nextIndex = 0;
        List<String> res = new ArrayList<>();
        if (target == null || target.length == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        int current = 1;
        while (nextIndex < target.length && current <= n) {
            if (current != target[nextIndex]) {
                stack.push(current);
                res.add(PUSH);
                ++current;
            } else {
                while (!stack.isEmpty()) {
                    if (preIndex == -1) {
                        stack.pop();
                        res.add(POP);
                    } else if (stack.peek() != target[preIndex]) {
                        stack.pop();
                        res.add(POP);
                    } else {
                        break;
                    }
                }
                stack.push(target[nextIndex]);
                res.add(PUSH);
                preIndex++;
                nextIndex++;
                current++;
            }
        }
        return res;
    }
}
