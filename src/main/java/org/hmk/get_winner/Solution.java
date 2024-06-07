package org.hmk.get_winner;

public class Solution {
    public int getWinner(int[] arr, int k) {
        if (k >= arr.length - 1) {
           int max = arr[0];
           for (int i = 1; i < arr.length; ++i) {
               max = Math.max(max, arr[i]);
           }
           return max;
        }
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; ++i) {
            Node cur = new Node(arr[i]);
            tail.next = cur;
            tail = cur;
        }

        int count = 0;
        while (true) {
            if (head.value > head.next.value) {
                count++;
                if (count >= k) {
                    return head.value;
                }
                Node nextTail = head.next;
                tail.next = nextTail;
                head.next = head.next.next;
                nextTail.next = null;
                tail = nextTail;
            } else {
                Node nextTail = head;
                head = head.next;
                tail.next = nextTail;
                nextTail.next = null;
                tail = nextTail;
                count = 1;
                if (count >= k) {
                    return head.value;
                }
            }
        }
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
