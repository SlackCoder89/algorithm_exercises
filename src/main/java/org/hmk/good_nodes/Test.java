package org.hmk.good_nodes;

import utils.Tree;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.goodNodes(Tree.buildTree("3,1,4,3,null,1,5")));
        System.out.println(solution.goodNodes(Tree.buildTree("3,3,null,4,2")));
    }
}
