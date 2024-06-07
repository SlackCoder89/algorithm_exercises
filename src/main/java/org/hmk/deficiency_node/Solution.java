package org.hmk.deficiency_node;

import utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        Map<TreeNode, Integer> sumMap = calculateSum(root);
        Map<TreeNode, TreeNode> parentMap = findParent(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isSufficient(node, limit, sumMap)) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            } else {
                TreeNode parent = parentMap.get(node);
                if (parent !=  null) {
                    if (parent.left == node) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else {
                    return null;
                }
            }
        }
        return root;
    }

    private boolean isSufficient(TreeNode root, int limit, Map<TreeNode, Integer> sumMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right == null && node.left == null && sumMap.get(node) >= limit) {
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

    private Map<TreeNode, TreeNode> findParent(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
        return parentMap;
    }

    private Map<TreeNode, Integer> calculateSum(TreeNode root) {
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        sumMap.put(root, root.val);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                sumMap.put(node.left, sumMap.get(node) + node.left.val);
                queue.offer(node.left);
            }
            if (node.right != null) {
                sumMap.put(node.right, sumMap.get(node) + node.right.val);
                queue.offer(node.right);
            }
        }
        return sumMap;
    }
}
