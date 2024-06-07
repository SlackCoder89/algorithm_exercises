package org.hmk.minimum_effort_path;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] effort = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; ++i) {
            for (int j = 0; j < heights[0].length; ++j) {
                effort[i][j] = Integer.MAX_VALUE;
            }
        }
        effort[effort.length - 1][effort[0].length - 1] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{heights.length - 1, heights[0].length - 1});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            updateSurroundings(p, heights, effort, queue);
        }
        return effort[0][0];
    }

    private void updateSurroundings(int[] position, int[][] heights, int[][] effort, Queue<int[]> queue) {
        int[][] directions = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        for (int[] direction : directions) {
            int[] p = new int[]{position[0] + direction[0], position[1] + direction[1]};
            if (p[0] < 0 || p[0] >= heights.length || p[1] < 0 || p[1] >= heights[0].length) {
                continue;
            }
            int e = Math.abs(heights[p[0]][p[1]] - heights[position[0]][position[1]]);
            e = Math.max(e, effort[position[0]][position[1]]);
            if (e < effort[p[0]][p[1]]) {
                effort[p[0]][p[1]] = e;
                queue.offer(p);
            }
        }
    }
}
