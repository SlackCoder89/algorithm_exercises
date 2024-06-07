package org.hmk.pairwise_swap_elements_of_a_linked_list;

public class Node {
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data) + " " + next;
    }
}
