package org.hmk.path_sum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//
//        TreeNode secondFirst = new TreeNode(4);
//        TreeNode secondSecond = new TreeNode(8);
//        root.left = secondFirst;
//        root.right = secondSecond;
//
//        TreeNode thirdFirst = new TreeNode(11);
//        TreeNode thirdSecond = new TreeNode(13);
//        TreeNode thirdThird = new TreeNode(4);
//        secondFirst.left = thirdFirst;
//        secondSecond.left = thirdSecond;
//        secondSecond.right = thirdThird;
//
//        TreeNode fourthFirst = new TreeNode(7);
//        TreeNode fourthSecond = new TreeNode(2);
//        TreeNode fourthThird = new TreeNode(5);
//        TreeNode fourthFourth = new TreeNode(1);
//        thirdFirst.left = fourthFirst;
//        thirdFirst.right = fourthSecond;
//        thirdThird.left = fourthThird;
//        thirdThird.right = fourthFourth;

        TreeNode root = new TreeNode(1);

        Solution s = new Solution();
        System.out.println(s.pathSum(root, 1));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return Collections.emptyList();
        }
        stack.push(root);
        if (root.val == targetSum && root.left == null && root.right == null) {
            List<Integer> fit = List.of(root.val);
            res.add(fit);
            return res;
        }
        Set<TreeNode> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            TreeNode left = cur.left;
            if (left != null && !visited.contains(left)) {
                stack.push(left);
                continue;
            }

            TreeNode right = cur.right;
            if (right != null && !visited.contains(right)) {
                stack.push(right);
                continue;
            }

            if (cur.left == null && cur.right == null) {
               int tmp = 0;
               List<Integer> fit = new ArrayList<>();
               for (TreeNode node : stack) {
                   tmp += node.val;
                   fit.add(node.val);
               }
               if (tmp == targetSum) {
                   res.add(fit);
               }
            }

            visited.add(cur);
            stack.pop();
        }

        return res;
    }
}
