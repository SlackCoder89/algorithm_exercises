package org.hmk.stock_buy_sell;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    ArrayList<ArrayList<Integer>> stockBuySell(int a[], int n) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < a.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (a[stack.peek()] < a[i]) {
                stack.push(i);
            } else {
                ArrayList<Integer> tmp = clearStack(stack, a);
                if (tmp.size() == 2) {
                    res.add(tmp);
                }
                stack.push(i);
            }
        }
        ArrayList<Integer> tmp = clearStack(stack, a);
        if (tmp.size() == 2) {
            res.add(tmp);
        }
        return res;
    }

    private ArrayList<Integer> clearStack(Stack<Integer> stack, int[] array) {
        int top = stack.get(stack.size() - 1);
        int bottom = stack.get(0);
        ArrayList<Integer> res = new ArrayList<>();
        if (array[bottom] < array[top]) {
            res.add(bottom);
            res.add(top);
        }
        stack.clear();
        return res;
    }
}
