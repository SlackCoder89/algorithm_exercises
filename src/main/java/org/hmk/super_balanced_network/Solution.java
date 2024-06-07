package org.hmk.super_balanced_network;

public class Solution {
    boolean isPossible(Node root) {
        if (root == null) {
            return true;
        }
        return doIsPossible(root, 0).isPossible;
    }

    private Result doIsPossible(Node root, int height) {
        Result leftResult = null;
        if (root.left != null) {
            leftResult = doIsPossible(root.left, height + 1);
            if (!leftResult.isPossible) {
                return new Result(false, null, null);
            }
        }

        Result rightResult = null;
        if (root.right != null) {
            rightResult = doIsPossible(root.right, height + 1);
            if (!rightResult.isPossible) {
                return new Result(false, null, null);
            }
        }

        boolean isPossible = true;
        Integer minHeight = height;
        Integer maxHeight = height;
        if (leftResult != null && rightResult != null) {
            minHeight = Math.min(leftResult.minHeight, rightResult.minHeight);
            maxHeight = Math.max(leftResult.maxHeight, rightResult.maxHeight);
            isPossible = (maxHeight - minHeight) <= 1;
        } else if (leftResult != null) {
            minHeight = leftResult.minHeight;
            maxHeight = leftResult.maxHeight;
        } else if (rightResult != null) {
            minHeight = rightResult.minHeight;
            maxHeight = rightResult.maxHeight;
        }
        return new Result(isPossible, minHeight, maxHeight);
    }
}

class Result {
    boolean isPossible;
    Integer minHeight;
    Integer maxHeight;

    public Result(boolean isPossible, Integer minHeight, Integer maxHeight) {
        this.isPossible = isPossible;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }
}
