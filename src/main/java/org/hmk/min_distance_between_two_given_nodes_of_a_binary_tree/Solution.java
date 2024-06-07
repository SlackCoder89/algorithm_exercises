package org.hmk.min_distance_between_two_given_nodes_of_a_binary_tree;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int findDist(Node root, int a, int b) {
        Result res = doFindDist(root, a, b);
        return res.dis;
    }

    private Result doFindDist(Node root, int a, int b) {
        Result lRes = new Result();
        if (root.left != null) {
            lRes = doFindDist(root.left, a, b);
        }
        if (lRes.dis != -1) {
            return lRes;
        }
        if (lRes.depth.size() == 1) {
            if (lRes.depth.containsKey(a)) {
                Result rRes = findTheOther(root.right, b);
                if (rRes.depth.size() == 1) {
                    Result res = new Result();
                    res.dis = lRes.depth.get(a) + rRes.depth.get(b);
                    return res;
                } else {
                    lRes.depth.put(a, lRes.depth.get(a) + 1);
                    return lRes;
                }
            } else {
                Result rRes = findTheOther(root.right, a);
                if (rRes.depth.size() == 1) {
                    Result res = new Result();
                    res.dis = lRes.depth.get(b) + rRes.depth.get(a);
                    return res;
                } else {
                    lRes.depth.put(b, lRes.depth.get(b) + 1);
                    return lRes;
                }
            }
        } else if (root.right != null) {
            Result rRes = doFindDist(root.right, a, b);
            if (rRes.dis != -1) {
                return rRes;
            } else if (rRes.depth.size() == 1) {
                if (rRes.depth.containsKey(a)) {
                    rRes.depth.put(a, rRes.depth.get(a) + 1);
                } else {
                    rRes.depth.put(b, rRes.depth.get(b) + 1);
                }
            } else {
                return rRes;
            }
        }
        return new Result();
    }

    private Result findTheOther(Node left, int b) {
        return null;
    }
}

class Result {
    Map<Integer, Integer> depth = new HashMap<>();
    int dis = -1;
}
