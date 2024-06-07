package org.hmk.deficiency_node;

import utils.TreeNode;

public class Solution1 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean left = false;
        if (root.left != null) {
            left = checkSufficientLeaf(root.left, root.val, limit);
        }
        if (!left) {
            root.left = null;
        }
        boolean right = false;
        if (root.right != null) {
            right = checkSufficientLeaf(root.right, root.val, limit);
        }
        if (!right) {
            root.right = null;
        }
        if (left || right) {
            return root;
        } else {
            return null;
        }
    }

    private boolean checkSufficientLeaf(TreeNode root, int sum, int limit) {
        if (root.left == null && root.right == null) {
            return root.val + sum >= limit;
        }

        boolean left = false;
        if (root.left != null) {
            left = checkSufficientLeaf(root.left, sum + root.val, limit);
            if (!left) {
                root.left = null;
            }
        }
        boolean right = false;
        if (root.right != null) {
            right = checkSufficientLeaf(root.right, sum + root.val, limit);
            if (!right) {
                root.right = null;
            }
        }

        return left || right;
    }
}
