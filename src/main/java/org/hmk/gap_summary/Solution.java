package org.hmk.gap_summary;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int start = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == current + 1) {
                current++;
            } else {
                if (current == start) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + current);
                }

                start = nums[i];
                current = nums[i];
            }
        }
        if (current == start) {
            res.add(String.valueOf(start));
        } else {
            res.add(start + "->" + current);
        }

        return res;
    }
}
