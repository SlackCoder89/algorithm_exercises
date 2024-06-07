package org.hmk.utils;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static TreeNode buildTree(String s) {
        return buildTree(s, ",", "null");
    }

    public static TreeNode buildTree(String s, String splitter, String nullStr) {
        String[] ss = s.split(splitter);
        int[] is = new int[ss.length];
        for (int i = 0; i < ss.length; ++i) {
            if (ss[i].equals(nullStr)) {
                is[i] = -1;
            } else {
                is[i] = Integer.parseInt(ss[i]);
            }
        }

        TreeNode root = new TreeNode(is[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (index < is.length) {
            TreeNode p = queue.poll();
            int leftVal = is[index++];
            TreeNode left = null;
            if (leftVal != -1) {
                left = new TreeNode(leftVal);
                queue.offer(left);
            }
            p.left = left;

            if (index >= is.length) {
                break;
            }
            int rightVal = is[index++];
            TreeNode right = null;
            if (rightVal != -1) {
                right = new TreeNode(rightVal);
                queue.offer(right);
            }
            p.right = right;
        }
        return root;
    }
}
