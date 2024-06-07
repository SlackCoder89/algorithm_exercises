package org.hmk.reverse_between;

import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int curIndex = 1;
        ListNode cur = head;
        ListNode before = null;
        ListNode after = null;
        ListNode reverseHead = null;

        while (cur != null) {
            if (curIndex == left - 1) {
                before= cur;
            }
            if (curIndex == left) {
                reverseHead = cur;
            }
            if (curIndex == right + 1) {
                after = cur;
                break;
            }
            curIndex++;
            cur = cur.next;
        }

        ListNode newReverseHead = reverseLink(reverseHead, right - left + 1);
        if (before != null) {
            before.next = newReverseHead;
        }
        reverseHead.next = after;
        if (left == 1) {
            head = newReverseHead;
        }
        return head;
    }

    private ListNode reverseLink(ListNode head, int length) {
        ListNode cur = head;
        int curIndex = 1;
        Map<ListNode, ListNode> preMap = new HashMap<>();
        while (cur != null) {
            if (curIndex >= length) {
                break;
            }
            curIndex++;
            if (cur.next == null) {
                break;
            }
            preMap.put(cur.next, cur);
            cur = cur.next;
        }
        ListNode ret = cur;
        while (cur != null) {
            if (!preMap.containsKey(cur)) {
                break;
            }
            cur.next = preMap.get(cur);
            cur = cur.next;
        }
        return ret;
    }
}
