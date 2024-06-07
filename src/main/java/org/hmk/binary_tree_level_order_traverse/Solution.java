package org.hmk.binary_tree_level_order_traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        queue.offer(root);
        TreeNode splitter = new TreeNode(Integer.MIN_VALUE, null, null);
        queue.offer(splitter);

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            TreeNode node = queue.poll();
            while (node != null && node != splitter) {
               level.add(node.val);
               if (node.left != null) {
                   queue.offer(node.left);
               }
               if (node.right != null) {
                   queue.offer(node.right);
               }
               node = queue.poll();
            }

            if (!queue.isEmpty()) {
                queue.offer(splitter);
            }
            result.add(level);
        }
        return result;
    }
}
