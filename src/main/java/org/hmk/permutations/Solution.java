package org.hmk.permutations;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
       int[][] inputs = new int[][]{
               {1,2,3},
               {0,1},
               {1}
       };
       Solution s = new Solution();
       for (int[] is : inputs) {
           System.out.println(Arrays.toString(is) + ": " + s.permute(is));
       }
    }

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
           s.add(i);
        }

        return doPermute(nums, new ArrayList<>(), s);
    }

    private List<List<Integer>> doPermute(int[] nums, List<Integer> init, Set<Integer> integers) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> copy = new HashSet<>(integers);
        if (integers.size() == 0) {
            res.add(init);
            return res;
        }
        for (Integer i : copy) {
            List<Integer> tmp = new ArrayList<>(init);
            tmp.add(nums[i]);
            integers.remove(i);
            res.addAll(doPermute(nums, tmp, integers));
            integers.add(i);
        }
        return res;
    }
}
