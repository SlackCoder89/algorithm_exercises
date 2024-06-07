package org.hmk.majority_element;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer n1 = null;
        int c1 = 0;
        Integer n2 = null;
        int c2 = 0;
        for (int num : nums) {
            if (n1 != null && n1 == num) {
                c1++;
            } else if (n2 != null && n2 == num) {
                c2++;
            } else if (c1 == 0) {
                n1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (n1 != null && n1 == num) {
                c1++;
            }
            if (n2 != null && n2 == num) {
                c2++;
            }
        }
        Set<Integer> set = new HashSet<>();
        if (c1 > nums.length / 3) {
            set.add(n1);
        }
        if (c2 > nums.length / 3) {
            set.add(n2);
        }
        return new ArrayList<>(set);
    }
}
