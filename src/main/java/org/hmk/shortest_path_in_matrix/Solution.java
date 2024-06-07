package org.hmk.shortest_path_in_matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        if (grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) {
            return -1;
        }
        if (grid.length == 1 && grid[0][0] == 0) {
            return 1;
        }

        Queue<List<int[]>> queue = new LinkedList<>();
        queue.offer(List.of(new int[]{0, 0}));
        visited[0][0] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            List<int[]> currentSteps = queue.poll();
            List<int[]> nextSteps = new ArrayList<>();
            ++count;
            for (int[] current : currentSteps) {
                List<int[]> tempNextSteps = calculateNextSteps(current, grid, visited);
                if (containsEnd(tempNextSteps, grid.length)) {
                    return count;
                } else {
                    nextSteps.addAll(tempNextSteps);
                }
            }
            if (nextSteps.isEmpty()) {
                break;
            }
            queue.offer(nextSteps);
        }
        return -1;
    }

    private boolean containsEnd(List<int[]> steps, int length) {
        for (int[] step : steps) {
            if (step[0] == length - 1 && step[1] == length - 1) {
                return true;
            }
        }
        return false;
    }

    private List<int[]> calculateNextSteps(int[] current, int[][] grid, boolean[][] visited) {
        int[][] directions = new int[][]{
                {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
        };
        List<int[]> nextSteps = new ArrayList<>();
        for (int[] direction : directions) {
            int[] nextStep = new int[]{
                    current[0] + direction[0], current[1] + direction[1]
            };
            if (!valid(nextStep, grid.length)) {
                continue;
            }
            if (grid[nextStep[0]][nextStep[1]] != 0) {
                continue;
            }
            if (visited[nextStep[0]][nextStep[1]]) {
                continue;
            } else {
                visited[nextStep[0]][nextStep[1]] = true;
                nextSteps.add(nextStep);
            }
        }
        return nextSteps;
    }

    private boolean valid(int[] step, int length) {
        return step[0] >= 0 && step[0] < length && step[1] >= 0 && step[1] < length;
    }
}
