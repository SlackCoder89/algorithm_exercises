package org.hmk.deficiency_node;

import utils.Tree;
import utils.TreeNode;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        TreeNode root = Tree.buildTree("1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14");
//        System.out.println(solution.sufficientSubset(root, 1));

//        TreeNode root = Tree.buildTree("5,4,8,11,null,17,4,7,1,null,null,5,3");
//        System.out.println(solution.sufficientSubset(root, 22));

//        TreeNode root = Tree.buildTree("1,2,-3,-5,null,4,null");
//        System.out.println(solution.sufficientSubset(root, -1));

        TreeNode root = Tree.buildTree("10,5,10");
        System.out.println(solution.sufficientSubset(root, 21));
    }
}
