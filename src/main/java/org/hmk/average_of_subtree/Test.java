package org.hmk.average_of_subtree;

import utils.Tree;

public class Test {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(i);
        System.out.println(1 ^ i);
        Solution solution = new Solution();
        System.out.println(solution.averageOfSubtree(Tree.buildTree("4,8,5,0,1,null,6")));
        System.out.println(solution.averageOfSubtree(Tree.buildTree("1")));
    }
}
