package org.hmk.utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public int max;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, int max) {
        this.val = val;
        this.max = max;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;

        TreeNode treeNode = (TreeNode) o;

        if (val != treeNode.val) return false;
        if (max != treeNode.max) return false;
        if (left != treeNode.left) return false;
        return right == treeNode.right;
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + max;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        StringBuilder res = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == Integer.MIN_VALUE) {
                res.append(", null");
            } else {
                res.append(", ").append(node.val);
                if (node.left == null) {
                    queue.offer(new TreeNode(Integer.MIN_VALUE));
                } else {
                    queue.offer(node.left);
                }
                if (node.right == null) {
                    queue.offer(new TreeNode(Integer.MIN_VALUE));
                } else {
                    queue.offer(node.right);
                }
            }
        }
        return res.toString();
    }
}
