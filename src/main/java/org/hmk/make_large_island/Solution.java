package org.hmk.make_large_island;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][][] inputs = new int[][][]{
//                {
//                        {1, 0}, {0, 1}
//                },
//                {
//                        {1, 1}, {1, 0}
//                },
//                {
//                        {1, 1}, {1, 1}
//                },
                {
                        {0,0},{1,1}
                }
        };

        Solution s = new Solution();
        for (int[][] input : inputs) {
            System.out.println(Arrays.deepToString(input) + ": " + s.largestIsland(input));
        }
    }

    public int largestIsland(int[][] grid) {
        Map<Position, Integer> positionBelong = new HashMap<>();
        Map<Integer, Integer> islandMap = new HashMap<>();

        int isLandSize = renderIsland(grid, positionBelong, islandMap);
        int connectionSize = calculateConnection(grid, positionBelong, islandMap);
        return Math.max(isLandSize, connectionSize);
    }

    private int calculateConnection(int[][] grid, Map<Position, Integer> positionBelong, Map<Integer, Integer> islandMap) {
        int max = -1;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                if (grid[i][j] == 0) {
                    int tmp = calculateNewIsland(grid, i, j, positionBelong, islandMap);
                    max = Math.max(max, tmp);
                }
            }
        }
        return max;
    }

    private int calculateNewIsland(int[][] grid, int i, int j, Map<Position, Integer> positionBelong, Map<Integer, Integer> islandMap) {
        Set<Integer> islandNos = new HashSet<>();
        addIsland(grid, i - 1, j, positionBelong, islandNos);
        addIsland(grid, i, j + 1, positionBelong, islandNos);
        addIsland(grid, i + 1, j, positionBelong, islandNos);
        addIsland(grid, i, j - 1, positionBelong, islandNos);

        int size = 1;
        for (Integer islandNo : islandNos) {
            size += islandMap.get(islandNo);
        }
        return size;
    }

    private void addIsland(int[][] grid, int i, int j, Map<Position, Integer> positionBelong, Set<Integer> islandNos) {
        Integer up = findIslandNo(i, j, grid.length, positionBelong);
        if (up != null) {
            islandNos.add(up);
        }
    }

    private int renderIsland(int[][] grid, Map<Position, Integer> positionBelong, Map<Integer, Integer> islandMap) {
        int max = -1;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                if (grid[i][j] == 1) {
                    Integer islandNo;

                    int up = i - 1;
                    islandNo = findIslandNo(up, j, grid.length, positionBelong);
                    if (islandNo == null) {
                        int right = j + 1;
                        islandNo = findIslandNo(i, right, grid.length, positionBelong);
                    }
                    if (islandNo == null) {
                       int down = i + 1;
                       islandNo = findIslandNo(down, j, grid.length, positionBelong);
                    }
                    if (islandNo == null) {
                        int left = j - 1;
                        islandNo = findIslandNo(i, left, grid.length, positionBelong);
                    }
                    if (islandNo == null) {
                        islandNo = grid.length * i + j;
                        int size = calculate(grid, i, j, islandNo, positionBelong);
                        max = Math.max(max, size);
                        islandMap.put(islandNo, size);
                    }
                    positionBelong.put(new Position(i, j), islandNo);
                }
            }
        }
        return max;
    }

    private int calculate(int[][] grid, int i, int j, Integer islandNo, Map<Position, Integer> positionBelong) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        visited[i][j] = true;
        int size = 1;
        size += doCalculate(grid, i - 1, j, visited, islandNo, positionBelong);
        size += doCalculate(grid, i, j + 1, visited, islandNo, positionBelong);
        size += doCalculate(grid, i + 1, j, visited, islandNo, positionBelong);
        size += doCalculate(grid, i, j - 1, visited, islandNo, positionBelong);

        return size;
    }

    private int doCalculate(int[][] grid, int i, int j, boolean[][] visited, Integer islandNo, Map<Position, Integer> positionBelong) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length) {
            return 0;
        }

        if (visited[i][j]) {
            return 0;
        }

        if (grid[i][j] == 0) {
            visited[i][j] = true;
            return 0;
        }

        int size = 1;
        visited[i][j] = true;
        positionBelong.put(new Position(i, j), islandNo);

        size += doCalculate(grid, i - 1, j, visited, islandNo, positionBelong);
        size += doCalculate(grid, i, j + 1, visited, islandNo, positionBelong);
        size += doCalculate(grid, i + 1, j, visited, islandNo, positionBelong);
        size += doCalculate(grid, i, j - 1, visited, islandNo, positionBelong);

        return size;

    }

    private Integer findIslandNo(int i, int j, int length, Map<Position, Integer> islandNo) {
        if (i < 0 || i >= length || j < 0 || j >= length) {
            return null;
        }
        return islandNo.get(new Position(i, j));
    }

}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}