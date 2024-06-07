package org.hmk.count_server;


public class Solution {
    public int countServers(int[][] grid) {
        int[][] connected = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; ++i) {
            if (isConnected(grid[i])) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] == 1) {
                        connected[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < grid[0].length; ++i) {
            if (isConnected(grid, i)) {
                for (int j = 0; j < grid.length; ++j) {
                    if (grid[j][i] == 1) {
                        connected[j][i] = 1;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < connected.length; ++i) {
            for (int j = 0; j < connected[0].length; ++j) {
                if (connected[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isConnected(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 1) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isConnected(int[][] matrix, int column) {
        int count = 0;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][column] == 1) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
