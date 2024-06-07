package org.hmk.operation_of_tree;

public class Test {
    public static void main(String[] args) {
        LockingTree tree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(tree.lock(2,2 ));
        System.out.println(tree.unlock(2, 3));
        System.out.println(tree.unlock(2, 2));
        System.out.println(tree.lock(4,5));
        System.out.println(tree.upgrade(0,1));
        System.out.println(tree.lock(0, 1));
    }
}
