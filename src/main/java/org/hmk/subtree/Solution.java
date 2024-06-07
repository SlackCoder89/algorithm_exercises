package org.hmk.subtree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }
        if (b == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(a);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (contains(node, b)) {
                return true;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return false;
    }

    private boolean contains(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        } else {
            return contains(a.left, b.left) && contains(a.right, b.right);
        }
    }
}
