package org.hmk.subtract;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int comp = 0;
            if (node.val < low) {
               comp = -1;
            }
            if (node.val > high) {
                comp = 1;
            }

            if (comp == 0) {
                if (node.left != null) {
                    parents.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    parents.put(node.right, node);
                    queue.offer(node.right);
                }
            } else if (comp == -1) {
                TreeNode parent = parents.get(node);
                if (parent != null) {
                    parent.left = node.right;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    parents.put(node.right, parent);
                }
            } else {
                TreeNode parent = parents.get(node);
                if (parent != null) {
                    parent.right = node.left;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    parents.put(node.left, parent);
                }
            }
        }
        return root;
    }
}
