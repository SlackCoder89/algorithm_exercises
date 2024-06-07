package org.hmk.reorder_list;

import java.util.Stack;

public class Solution {
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
            count++;
        }
        count /= 2;
        boolean odd = count % 2 == 0;
        cur = head;
        ListNode next = head.next;
        for (int i = 0; i < count; ++i) {
            ListNode insert = stack.pop();
            cur.next = insert;
            insert.next = next;
            cur = next;
            next = next.next;
        }
        if (odd && next != null) {
            next.next.next = null;
        } else if (!odd) {
            next.next = null;
        }
    }
}
