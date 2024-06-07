package org.hmk.split_list_to_parts;

public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        int secondHalfSize = size / k;
        int firstHalfLength = 0;
        int firstHalfSize = secondHalfSize;
        if (secondHalfSize * k < size) {
            firstHalfLength = size - secondHalfSize * k;
            firstHalfSize = secondHalfSize + 1;
        }

        ListNode[] ret = new ListNode[k];
        cur = head;
        ListNode[] tmp;
        for (int i = 0; i < k; ++i) {
            if (i < firstHalfLength) {
                tmp = teardownList(cur, firstHalfSize);
            } else {
                tmp = teardownList(cur, secondHalfSize);
            }
            ret[i] = tmp[0];
            cur = tmp[1];
        }
        return ret;
    }

    private ListNode[] teardownList(ListNode head, int length) {
        ListNode cur = head;
        ListNode pre = null;
        int count = 0;
        while (count < length) {
            count++;
            pre = cur;
            cur = cur.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return new ListNode[]{head, cur};
    }
}
