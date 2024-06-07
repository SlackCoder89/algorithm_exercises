package org.hmk.check_for_bst;

public class Solution {
    boolean isBST(Node root) {
        return doIsBST(root).isBST;
    }

    private Result doIsBST(Node root) {
        if (root == null) {
            return new Result(false);
        }
        Result lRes = null;
        if (root.left != null) {
            lRes = doIsBST(root.left);
            if (!lRes.isBST) {
                return new Result(false);
            }
        }

        Result rRes = null;
        if (root.right != null) {
            rRes = doIsBST(root.right);
            if (!rRes.isBST) {
                return new Result(false);
            }
        }

        if (lRes != null && rRes != null) {
            if (lRes.max < root.data && rRes.min > root.data) {
                return new Result(lRes.min, rRes.max, true);
            } else {
                return new Result(false);
            }
        } else if (lRes != null) {
            if (lRes.max < root.data) {
                return new Result(lRes.min, root.data, true);
            } else {
                return new Result(false);
            }
        } else if (rRes != null) {
            if (rRes.min > root.data) {
                return new Result(root.data, rRes.max, true);
            } else {
                return new Result(false);
            }
        } else {
            return new Result(root.data, root.data, true);
        }
    }
}

class Result {
    Integer min;
    Integer max;
    Boolean isBST;

    public Result(Boolean isBST) {
        this.isBST = isBST;
    }

    public Result(Integer min, Integer max, Boolean isBST) {
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}
