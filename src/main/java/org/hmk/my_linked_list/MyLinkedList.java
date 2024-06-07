package org.hmk.my_linked_list;

public class MyLinkedList {
    Node head;

    public MyLinkedList() {
    }

    public int get(int index) {
        Node cur = head;
        for (int i = 0; i < index; ++i) {
            if (cur == null) {
                return -1;
            } else {
                cur = cur.next;
            }
        }
        if (cur == null) {
            return -1;
        } else {
            return cur.value;
        }
    }

    public void addAtHead(int val) {
        Node insert = new Node(val);
        insert.next = head;
        head = insert;
    }

    public void addAtTail(int val) {
        Node insert = new Node(val);
        if (head == null) {
            head = insert;
        } else {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = insert;
        }
    }

    public void addAtIndex(int index, int val) {
        Node insert = new Node(val);
        Node pre = null;
        Node cur = head;
        int count = 0;

        while (count < index) {
            ++count;
            if (cur != null) {
                pre = cur;
                cur = cur.next;
            } else {
                break;
            }
        }

        if (count == index) {
            insert.next = cur;
            if (pre == null) {
                head = insert;
            } else {
                pre.next = insert;
            }
        }
    }

    public void deleteAtIndex(int index) {
        Node pre = null;
        Node cur = head;
        int count = 0;

        while (count < index) {
            ++count;
            if (cur != null) {
                pre = cur;
                cur = cur.next;
            } else {
                break;
            }
        }

        if (count == index) {
            if (cur != null) {
                if (pre == null) {
                    head = cur.next;
                } else {
                    pre.next = cur.next;
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