package org.hmk.min_distance_between_two_given_nodes_of_a_binary_tree;

public class Node {
    int data;
    Node left, right;
    Node(int item)    {
        data = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
