package org.hmk.largest_values;

import utils.TreeNode;

import java.util.*;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int nextCount = 0;
            while (count > 0) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
                count--;
            }
            result.add(max);
            count = nextCount;
        }
        return result;
    }
}
