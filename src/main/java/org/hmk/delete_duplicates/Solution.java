package org.hmk.delete_duplicates;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> duplicates = new HashSet<>();
        if (head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                duplicates.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }

        ListNode ret = head;
        pre = null;
        cur = head;
        while (cur != null) {
            if (duplicates.contains(cur.val)) {
                if (pre == null) {
                    ret = cur.next;
                } else {
                    pre.next = cur.next;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return ret;
    }
}