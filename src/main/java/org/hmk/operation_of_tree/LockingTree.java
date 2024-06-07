package org.hmk.operation_of_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LockingTree {
    Node[] nodes;
    public LockingTree(int[] parent) {
        nodes = new Node[parent.length];
        nodes[0] = new Node();
        nodes[0].parent = -1;
        for (int i = 1; i < parent.length; ++i) {
            if (nodes[i] == null) {
                nodes[i] = new Node();
            }
            nodes[i].parent = parent[i];
            if (nodes[parent[i]] == null) {
                nodes[parent[i]] = new Node();
            }
            nodes[parent[i]].children.add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (nodes[num].user != 0) {
            return false;
        }
        nodes[num].user = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (nodes[num].user != user) {
            return false;
        }
        nodes[num].user = 0;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (nodes[num].user != 0) {
            return false;
        }
        List<Integer> lockedChildren = findLockedChildren(num);
        if (lockedChildren.isEmpty()) {
            return false;
        }
        List<Integer> lockedParents = findLockedParents(num);
        if (!lockedParents.isEmpty()) {
            return false;
        }
        for (int child : lockedChildren) {
            unlock(child, nodes[child].user);
        }
        lock(num, user);
        return true;
    }

    private List<Integer> findLockedParents(int num) {
        List<Integer> parents = new ArrayList<>();
        num = nodes[num].parent;
        while (num != -1) {
            if (nodes[num].user != 0) {
                parents.add(num);
            }
            num = nodes[num].parent;
        }
        return parents;
    }

    private List<Integer> findLockedChildren(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        List<Integer> children = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int n : nodes[node].children) {
                queue.offer(n);
                if (nodes[n].user != 0) {
                    children.add(n);
                }
            }
        }
        return children;
    }
}
