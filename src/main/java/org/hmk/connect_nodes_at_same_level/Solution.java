package org.hmk.connect_nodes_at_same_level;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void connect(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()) {
            int nextSize = 0;
            for (int i = 0; i < size; ++i) {
                Node n = queue.poll();
                if (i + 1 < size) {
                    n.nextRight = queue.peek();
                }
                if (n.left != null) {
                    queue.offer(n.left);
                    nextSize++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    nextSize++;
                }
            }
            size = nextSize;
        }
    }
}
