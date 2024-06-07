package org.hmk.robbing_three;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> containsCache = new HashMap<>();
        Map<TreeNode, Integer> notContainsCache = new HashMap<>();
        int a = root.val + notContainsRoot(root.left, containsCache, notContainsCache) + notContainsRoot(root.right, containsCache, notContainsCache);
        int b = Math.max(containsRoot(root.left, containsCache, notContainsCache), notContainsRoot(root.left, containsCache, notContainsCache)) + Math.max(containsRoot(root.right, containsCache, notContainsCache), notContainsRoot(root.right, containsCache, notContainsCache));
        return Math.max(a, b);
    }

    private int containsRoot(TreeNode root, Map<TreeNode, Integer> containsCache, Map<TreeNode, Integer> notContainsCache) {
        if (root == null) {
            return 0;
        }
        if (containsCache.containsKey(root)) {
            return containsCache.get(root);
        }
        int res = root.val + notContainsRoot(root.left, containsCache, notContainsCache) + notContainsRoot(root.right, containsCache, notContainsCache);
        containsCache.put(root, res);
        return res;
    }

    private int notContainsRoot(TreeNode root, Map<TreeNode, Integer> containsCache, Map<TreeNode, Integer> notContainsCache) {
        if (root == null) {
            return 0;
        }
        if (notContainsCache.containsKey(root)) {
            return notContainsCache.get(root);
        }
        int res = Math.max(containsRoot(root.left, containsCache, notContainsCache), notContainsRoot(root.left, containsCache, notContainsCache)) + Math.max(containsRoot(root.right, containsCache, notContainsCache), notContainsRoot(root.right, containsCache, notContainsCache));
        notContainsCache.put(root, res);
        return res;
    }
}
