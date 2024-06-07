package org.hmk.average_of_subtree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int averageOfSubtree(TreeNode root) {
        Map<TreeNode, Integer> sum = new HashMap<>();
        Map<TreeNode, Integer> number = new HashMap<>();
        dfsSumAndNumber(root, sum, number);
        return dfsAverage(root, sum, number);
    }

    private int dfsAverage(TreeNode root, Map<TreeNode, Integer> sum, Map<TreeNode, Integer> number) {
        int count = 0;
        if (root.left != null) {
            count += dfsAverage(root.left, sum, number);
        }
        if (root.right != null) {
            count += dfsAverage(root.right, sum, number);
        }
        if (root.val == sum.get(root) / number.get(root)) {
            count++;
        }
        return count;
    }

    private void dfsSumAndNumber(TreeNode root, Map<TreeNode, Integer> sum, Map<TreeNode, Integer> number) {
        int sumOfRoot = root.val;
        int numberOfRoot = 1;
        if (root.left != null) {
            dfsSumAndNumber(root.left, sum, number);
            sumOfRoot += sum.get(root.left);
            numberOfRoot += number.get(root.left);
        }
        if (root.right != null) {
            dfsSumAndNumber(root.right, sum, number);
            sumOfRoot += sum.get(root.right);
            numberOfRoot += number.get(root.right);
        }
        sum.put(root, sumOfRoot);
        number.put(root, numberOfRoot);
    }
}
