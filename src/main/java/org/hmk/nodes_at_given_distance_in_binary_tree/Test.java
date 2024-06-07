package org.hmk.nodes_at_given_distance_in_binary_tree;

import java.util.LinkedList;
import java.util.Queue;


public class Test {
    public static void main(String[] args) {
        System.out.println(Solution.KDistanceNodes(buildTree(
                "20 8 22 4 12 N N N N 10 14", " ", "N"
        ), 8, 2));
        System.out.println(Solution.KDistanceNodes(buildTree(
                "20 7 24 4 3 N N N N 1", " ", "N"
        ), 7, 2));
    }

    public static Node buildTree(String s, String splitter, String nullStr) {
        String[] ss = s.split(splitter);
        int[] is = new int[ss.length];
        for (int i = 0; i < ss.length; ++i) {
            if (ss[i].equals(nullStr)) {
                is[i] = -1;
            } else {
                is[i] = Integer.parseInt(ss[i]);
            }
        }

        Node root = new Node(is[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (index < is.length) {
            Node p = queue.poll();
            int leftVal = is[index++];
            Node left = null;
            if (leftVal != -1) {
                left = new Node(leftVal);
                queue.offer(left);
            }
            p.left = left;

            if (index >= is.length) {
                break;
            }
            int rightVal = is[index++];
            Node right = null;
            if (rightVal != -1) {
                right = new Node(rightVal);
                queue.offer(right);
            }
            p.right = right;
        }
        return root;
    }
}
