package org.hmk.hard_arrangement;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.arrange(buildArrayList(new int[]{3, 2, 1}),
                buildArrayList(new int[]{0, 1, 1}), 3));
        System.out.println(s.arrange(buildArrayList(new int[]{5, 3, 2, 6, 1, 4}),
                buildArrayList(new int[]{0, 1, 2, 0, 3, 2}), 6));
    }

    private static ArrayList<Integer> buildArrayList(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int a : arr) {
            res.add(a);
        }
        return res;
    }
}
