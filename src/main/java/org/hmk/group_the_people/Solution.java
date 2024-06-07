package org.hmk.group_the_people;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; ++i) {
            if (groups.containsKey(groupSizes[i])) {
                if (groups.get(groupSizes[i]).size() < groupSizes[i]) {
                    groups.get(groupSizes[i]).add(i);
                } else {
                    ret.add(groups.get(groupSizes[i]));
                    List<Integer> group = new ArrayList<>();
                    group.add(i);
                    groups.put(groupSizes[i], group);
                }
            } else {
                List<Integer> group = new ArrayList<>();
                group.add(i);
                groups.put(groupSizes[i], group);
            }
        }
        ret.addAll(groups.values());
        return ret;
    }
}
