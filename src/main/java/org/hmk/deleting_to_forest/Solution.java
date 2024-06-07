package org.hmk.deleting_to_forest;

import utils.TreeNode;

import java.util.*;

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deletes = new HashSet<>();
        for (int i : to_delete) {
            deletes.add(i);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Set<TreeNode> res = new HashSet<>();
        res.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right !=  null) {
                parents.put(node.right, node);
                queue.offer(node.right);
            }
            if (node.left != null) {
                parents.put(node.left, node);
                queue.offer(node.left);
            }

            if (deletes.contains(node.val)) {
                TreeNode parent = parents.get(node);
                if (parent !=  null) {
                    if (parent.right == node) {
                        parent.right = null;
                    } else if (parent.left == node) {
                        parent.left = null;
                    }
                }
                if (node.left != null) {
                    res.add(node.left);
                    node.left = null;
                }
                if (node.right != null) {
                    res.add(node.right);
                    node.right = null;
                }
                res.remove(node);
            }
        }

        return new ArrayList<>(res);
    }
}
