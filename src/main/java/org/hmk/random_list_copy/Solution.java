package org.hmk.random_list_copy;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node ret = new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(head, ret);
        Node cur = head;
        Node copyCur = ret;

        while (cur != null) {
            if (cur.next != null) {
                Node next = cur.next;
                Node copyNext = new Node(next.val);
                map.put(next, copyNext);
                copyCur.next = copyNext;

                cur = cur.next;
                copyCur = copyCur.next;
            } else {
                cur = null;
            }
        }

        cur = head;
        copyCur = ret;
        while (cur != null) {
            if (cur.random != null) {
                copyCur.random = map.get(cur.random);
            }
            cur = cur.next;
            copyCur = copyCur.next;
        }
        return ret;
    }
}
