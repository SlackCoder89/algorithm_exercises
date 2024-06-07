package org.hmk.pairwise_swap_elements_of_a_linked_list;

public class Solution {
    public Node pairwiseSwap(Node head) {
        if (head == null) {
            return head;
        }
        Node first = head;
        if (first.next == null) {
            return head;
        }
        Node newHead = head.next;
        Node second = first.next.next;
        Node pre = null;

        while (first != null) {
            Node tmp = doPairwiseSwap(first, second);
            if (pre != null) {
                pre.next = tmp;
            }
            pre = tmp.next;
            first = second;
            if (second == null || second.next == null) {
                break;
            }
            second = second.next.next;
        }
        return newHead;
    }

    private Node doPairwiseSwap(Node first, Node second) {
        Node tmp = first.next;
        first.next = second;
        tmp.next = first;
        return tmp;
    }
}
