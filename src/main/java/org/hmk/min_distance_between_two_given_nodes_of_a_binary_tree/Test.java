package org.hmk.min_distance_between_two_given_nodes_of_a_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findDist(buildRoot(new int[]{
//               1, 2, 3
//        }), 2, 3));
        System.out.println(solution.findDist(buildRoot(new int[]{
                11, 22, 33, 44, 55, 66, 77
        }), 77, 22));
    }

    private static Node buildRoot(int[] is) {
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
