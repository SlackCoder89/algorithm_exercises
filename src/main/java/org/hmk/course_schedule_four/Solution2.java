package org.hmk.course_schedule_four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            List<Integer> children = childrenMap.computeIfAbsent(prerequisite[0], k -> new ArrayList<>());
            children.add(prerequisite[1]);
        }

        boolean[][] matrix = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; ++i) {
            List<Integer> children =  childrenMap.getOrDefault(i, new ArrayList<>());
            for (Integer child : children) {
                doDeepFirstSearch(childrenMap, i, child, matrix);
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(matrix[query[0]][query[1]]);
        }
        return result;
    }

    private void doDeepFirstSearch(Map<Integer, List<Integer>> childrenMap, Integer bottom, Integer cur, boolean[][] matrix) {
        matrix[bottom][cur] = true;

        List<Integer> children = childrenMap.getOrDefault(cur, new ArrayList<>());
        for (Integer child : children) {
            doDeepFirstSearch(childrenMap, bottom, child, matrix);
        }
    }
}
