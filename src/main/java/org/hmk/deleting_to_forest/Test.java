package org.hmk.deleting_to_forest;

import utils.Tree;
import utils.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        TreeNode root = Tree.buildTree("1,2,3,4,5,6,7");
//        System.out.println(solution.delNodes(root, new int[]{3,5}));

        TreeNode root = Tree.buildTree("1,2,4,null,3");
        System.out.println(solution.delNodes(root, new int[]{3}));
    }
}
