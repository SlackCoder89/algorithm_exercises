package org.hmk.super_balanced_network;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPossible(buildTree("1 2 3 N N 4 6 N 5 N N 7 N", " ", "N")));
        System.out.println(s.isPossible(buildTree("1 2 3 4 5 6 7", " ", "N")));
        System.out.println(s.isPossible(buildTree("1 2 3 4 5 N N 6", " ", "N")));
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
