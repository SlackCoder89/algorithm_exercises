package org.hmk.good_nodes;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int goodNodes(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> maxMap = new HashMap<>();
        maxMap.put(root, root.val);

        int count = 1;
        count += dfs(root, maxMap);
        return count;
    }

    private int dfs(TreeNode node, Map<TreeNode, Integer> maxMap) {
        int count = 0;
        if (node.left != null) {
            if (maxMap.get(node) <= node.left.val) {
                count++;
            }
            maxMap.put(node.left, Math.max(maxMap.get(node), node.left.val));
            count += dfs(node.left, maxMap);
        }
        if (node.right != null) {
            if (maxMap.get(node) <= node.right.val) {
                count++;
            }
            maxMap.put(node.right, Math.max(maxMap.get(node), node.right.val));
            count += dfs(node.right, maxMap);
        }
        return count;
    }
}
