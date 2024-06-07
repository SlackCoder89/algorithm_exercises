package org.hmk.course_schedule;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> unvisited = new HashSet<>();
        for (int i = 0; i < numCourses; ++i) {
            unvisited.add(i);
        }
        for(int[] pair : prerequisites) {
            List<Integer> values;
            if (map.containsKey(pair[1])) {
                values = map.get(pair[1]);
            } else {
                values = new LinkedList<>();
                map.put(pair[1], values);
            }
            values.add(pair[0]);
        }

        Stack<Integer> result = new Stack<>();
        List<Integer> set = new ArrayList<>(unvisited);
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        boolean circled = deepFirstSearch(map, set, unvisited, visited, visiting, result);
        if (circled) {
            return new int[0];
        } else {
            int[] res = new int[numCourses];
            int index = 0;
            while (!result.isEmpty()) {
                res[index] = result.pop();
                index++;
            }
            return res;
        }
    }

    private static boolean deepFirstSearch(Map<Integer, List<Integer>> map, List<Integer> set, Set<Integer> unvisited, Set<Integer> visited, Set<Integer> visiting, Stack<Integer> result) {
        for (Integer i : set) {
            if (visited.contains(i)) {
                continue;
            }
            boolean circled = doDeepFirstSearch(map, unvisited, visited, visiting, result, i);
            if (circled) {
                return true;
            }
        }
        return false;
    }

    private static boolean doDeepFirstSearch(Map<Integer, List<Integer>> map, Set<Integer> unvisited, Set<Integer> visited, Set<Integer> visiting, Stack<Integer> result, int i) {
        visiting.add(i);
        List<Integer> children = map.get(i);
        if (children != null && !children.isEmpty()) {
            for (Integer child : children) {
                if (visiting.contains(child)) {
                    return true;
                } else if (unvisited.contains(child)) {
                    boolean circled = doDeepFirstSearch(map, unvisited, visited, visiting, result, child);
                    if (circled) {
                        return true;
                    }
                }
            }
        }
        result.push(i);
        unvisited.remove(i);
        visiting.remove(i);
        visited.add(i);
        return false;
    }
}
