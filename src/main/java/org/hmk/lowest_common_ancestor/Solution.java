package org.hmk.lowest_common_ancestor;

import java.util.*;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        set.add(q);
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!set.isEmpty() && !queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                extractParents(set, parents, queue, cur, cur.left);
            }
            if (cur.right != null) {
                extractParents(set, parents, queue, cur, cur.right);
            }
        }

        List<TreeNode> pParents = getParents(p, parents);
        List<TreeNode> qParents = getParents(q, parents);
        TreeNode parent = null;
        int length = Math.min(pParents.size(), qParents.size());
        for (int i = 0; i < length; ++i) {
            if (pParents.get(i) != qParents.get(i)) {
                break;
            }
            parent = pParents.get(i);
        }
        return parent;
    }

    private List<TreeNode> getParents(TreeNode p, Map<TreeNode, TreeNode> parents) {
        TreeNode child = p;
        List<TreeNode> res = new ArrayList<>();
        res.add(p);
        while (child != null) {
            TreeNode parent = parents.get(child);
            if (parent == null) {
                break;
            }
            res.add(parent);
            child = parent;
        }
        Collections.reverse(res);
        return res;
    }

    private static void extractParents(Set<TreeNode> set, Map<TreeNode, TreeNode> parents, Queue<TreeNode> queue, TreeNode cur, TreeNode child) {
        parents.put(child, cur);
        queue.offer(child);
        set.remove(child);
    }
}
