package org.hmk.subtraction_in_linked_list;

public class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // translate node to arraylist
        java.util.List<Node> list1 = convert2List(head1);
        java.util.List<Node> list2 = convert2List(head2);

        // get the maximum one
        java.util.List<Node> max = max(list1, list2);
        // get the minimum one
        java.util.List<Node> min = min(list1, list2);

        // calculate subtraction
        java.util.List<Node> diff = subtraction(max, min);

        return convert2Node(diff);
    }

    private Node convert2Node(java.util.List<Node> list) {
        Node res = null;
        for (int i = list.size() - 1; i >= 0; --i) {
            Node pre = list.get(i);
            pre.next = res;
            res = pre;
        }
        while (res != null) {
            if (res.data == 0) {
                res = res.next;
            } else {
                break;
            }
        }
        if (res == null) {
            res = new Node(0);
        }
        return res;
    }

    private java.util.List<Node> subtraction(java.util.List<Node> max, java.util.List<Node> min) {
        java.util.List<Node> res = new java.util.ArrayList<>();
        boolean borrow = false;
        for (int i = max.size() - 1; i >= 0; --i) {
            int a = max.get(i).data;
            int b = 0;
            if (min.size() - 1 >= max.size() - 1 - i) {
                b = min.get(min.size() - 1 - (max.size() - 1 - i)).data;
            }
            if (borrow) {
                a--;
            }
            if (a >= b) {
                res.add(0, new Node(a - b));
                borrow = false;
            } else {
                res.add(0, new Node(a + 10 - b));
                borrow = true;
            }
        }
        return res;
    }

    private java.util.List<Node> min(java.util.List<Node> list1, java.util.List<Node> list2) {
        if (list1.size() < list2.size()) {
            return list1;
        } else if (list1.size() > list2.size()) {
            return list2;
        }

        for (int i = 0; i < list1.size(); ++i) {
            if (list1.get(i).data < list2.get(i).data) {
                return list1;
            } else if (list1.get(i).data > list2.get(i).data) {
                return list2;
            }
        }
        return list1;
    }

    private java.util.List<Node> max(java.util.List<Node> list1, java.util.List<Node> list2) {
        if (list1.size() > list2.size()) {
            return list1;
        } else if (list1.size() < list2.size()) {
            return list2;
        }

        for (int i = 0; i < list1.size(); ++i) {
            if (list1.get(i).data > list2.get(i).data) {
                return list1;
            } else if (list1.get(i).data < list2.get(i).data) {
                return list2;
            }
        }
        return list1;
    }

    private java.util.List<Node> convert2List(Node head) {
        java.util.List<Node> res = new java.util.ArrayList<>();
        while (head != null) {
            if (head.data != 0 || !res.isEmpty()) {
                res.add(head);
            }
            head = head.next;
        }
        return res;
    }
}