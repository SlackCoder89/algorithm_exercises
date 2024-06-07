package org.hmk.course_schedule_four;

import java.util.*;

public class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();
        Map<Integer, Integer> parentCountMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> children = childrenMap.computeIfAbsent(prerequisite[0], k -> new ArrayList<>());
            children.add(prerequisite[1]);

            Integer parentCount = parentCountMap.getOrDefault(prerequisite[1], 0);
            parentCount++;
            parentCountMap.put(prerequisite[1], parentCount);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            Integer parentCount = parentCountMap.getOrDefault(i, 0);
            if (parentCount == 0) {
                queue.offer(i);
            }
        }

        // width first search to build prerequisite matrix
        boolean[][] matrix = new boolean[numCourses][numCourses];
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            List<Integer> children = childrenMap.getOrDefault(cur, new ArrayList<>());
            for (Integer child : children) {
                matrix[cur][child] = true;
                for (int i = 0; i < numCourses; ++i) {
                    matrix[i][child] = matrix[i][child] || matrix[i][cur];
                }

                Integer parentCount = parentCountMap.getOrDefault(child, 0);
                parentCount--;
                parentCountMap.put(child, parentCount);
                if (parentCount <= 0) {
                    queue.offer(child);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(matrix[query[0]][query[1]]);
        }
        return result;
    }
}
