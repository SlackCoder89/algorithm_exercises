package org.hmk.number_of_islands;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        char[][][] inputs = new char[][][]{
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                },
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }
        };

        Solution solution = new Solution();
        for (char[][] input : inputs) {
            System.out.println(Arrays.deepToString(input) + ": " + solution.numIslands(input));
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(i, j));

        while (!queue.isEmpty()) {
            Position cur = queue.remove();
            add(queue, grid, cur.x - 1, cur.y);
            add(queue, grid,  cur.x, cur.y + 1);
            add(queue, grid, cur.x + 1, cur.y);
            add(queue, grid, cur.x, cur.y - 1);
            grid[cur.x][cur.y] = '0';
        }
    }

    private void add(Queue<Position> queue, char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        queue.offer(new Position(i, j));
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
