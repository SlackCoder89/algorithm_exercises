package org.hmk.validate_binary_tree_nodes;

import java.util.Arrays;

public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] != -1) {
                if (parents[leftChild[i]] != -1) {
                    return false;
                }
                if (leftChild[i] == i) {
                    return false;
                }
                int parentIndex = i;
                while (parents[parentIndex] != -1) {
                    if (parents[parentIndex] == leftChild[i]) {
                        return false;
                    }
                    parentIndex = parents[parentIndex];
                }
                parents[leftChild[i]] = parentIndex;
            }
            if (rightChild[i] != -1) {
                if (parents[rightChild[i]] != -1) {
                    return false;
                }
                if (rightChild[i] == i) {
                    return false;
                }
                int parentIndex = i;
                while (parents[parentIndex] != -1) {
                    if (parents[parentIndex] == rightChild[i]) {
                        return false;
                    }
                    parentIndex = parents[parentIndex];
                }
                parents[rightChild[i]] = parentIndex;
            }
        }
        int countOfRoot = 0;
        for (int i : parents) {
            if (i == -1) {
                countOfRoot++;
                if (countOfRoot > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Node {
    Node parent;
    Node left;
    Node right;
}
