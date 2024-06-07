package org.hmk.course_schedule;

import java.util.*;

public class Solution1 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> ins = new HashMap<>();
        Map<Integer, List<Integer>> outs = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            ins.put(i, new ArrayList<>());
            outs.put(i, new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            List<Integer> is = ins.get(pair[0]);
            is.add(pair[1]);

            List<Integer> os = outs.get(pair[1]);
            os.add(pair[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : ins.entrySet()) {
            if (entry.getValue().isEmpty()) {
                queue.offer(entry.getKey());
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            res.add(i);
            for (Integer o : outs.get(i)) {
                List<Integer> is = ins.get(o);
                is.remove(i);
                if (is.isEmpty()) {
                    queue.offer(o);
                }
            }
        }
        if (res.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; ++i) {
                result[i] = res.get(i);
            }
            return result;
        } else {
            return new int[0];
        }
    }
}
