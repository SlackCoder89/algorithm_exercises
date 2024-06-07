package org.hmk.subtraction_in_linked_list;

public class Node {
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = this;
        while (node != null) {
            sb.append(node.data).append(", ");
            node = node.next;
        }
        return sb.toString();
    }
}
