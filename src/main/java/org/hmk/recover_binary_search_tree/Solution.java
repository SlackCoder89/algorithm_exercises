package org.hmk.recover_binary_search_tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public static void main(String[] args) {
//        int[] input = new int[]{1, 3, -1, -1, 2};
//        TreeNode root = composeTree(input);
        TreeNode root = new TreeNode();
        root.val = 1;

        TreeNode secondFirst = new TreeNode();
        secondFirst.val = 3;
        root.left = secondFirst;

        TreeNode thirdSecond = new TreeNode();
        thirdSecond.val = 2;
        secondFirst.right = thirdSecond;

        Solution s = new Solution();
        s.recoverTree(root);
        System.out.println("finished");
    }

    private static TreeNode composeTree(int[] input) {
        TreeNode root = new TreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean first = true;
        for (int i : input) {
            if (first) {
                root.val = i;
                queue.offer(root);
            } else {

            }
        }
        return root;
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> old = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> processed = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left != null && !processed.contains(cur.left)) {
                stack.push(cur.left);
                continue;
            }

            cur = stack.pop();
            old.add(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            processed.add(cur);
        }

//        List<TreeNode> sorted = new ArrayList<>(old);
//        sorted.sort(Comparator.comparingInt(o -> o.val));
//        for (int i = 0; i < sorted.size(); ++i) {
//            if (sorted.get(i).val != old.get(i).val) {
//                int tmp = old.get(i).val;
//                old.get(i).val = sorted.get(i).val;
//                sorted.get(i).val = tmp;
//                break;
//            }
//        }
    }
}