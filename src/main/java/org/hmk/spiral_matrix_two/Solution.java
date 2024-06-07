package org.hmk.spiral_matrix_two;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] inputs = new int[]{
                3,
                1,
                4
        };
        Solution solution = new Solution();

        for (int input : inputs) {
            System.out.println(input + ": " + Arrays.deepToString(solution.generateMatrix(input)));
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x = 0;
        int y = 0;
        int value = 1;
        String direction = "right";
        while (x >= 0 && x < n)  {
            result[x][y] = value;
            value++;

            Position position = decideNextPosition(new Position(x, y, direction), result);
            x = position.x;
            y = position.y;
            direction = position.direction;

        }
        return result;
    }

    private Position decideNextPosition(Position position, int[][] result) {
        int nx = 0, ny = 0;
        Position newPosition = new Position(-1, -1, "right");
        switch (position.direction) {
            case "right":
                nx = position.x;
                ny = position.y + 1;
                if (validate(nx, ny, result)) {
                    return new Position(nx, ny, position.direction);
                } else {
                    nx = position.x + 1;
                    ny = position.y;
                    newPosition = new Position(nx, ny, "down");
                    break;
                }
            case "down":
                nx = position.x + 1;
                ny = position.y;
                if (validate(nx, ny, result)) {
                    return new Position(nx, ny, position.direction);
                } else {
                    nx = position.x;
                    ny = position.y - 1;
                    newPosition = new Position(nx, ny, "left");
                    break;
                }
            case "left":
                nx = position.x;
                ny = position.y - 1;
                if (validate(nx, ny, result)) {
                    return new Position(nx, ny, position.direction);
                } else {
                    nx = position.x - 1;
                    ny = position.y;
                    newPosition = new Position(nx, ny, "up");
                    break;
                }
            case "up":
                nx = position.x - 1;
                ny = position.y;
                if (validate(nx, ny, result)) {
                    return new Position(nx, ny, position.direction);
                } else {
                    nx = position.x;
                    ny = position.y + 1;
                    newPosition = new Position(nx, ny, "right");
                    break;
                }
        }
        if (validate(newPosition.x, newPosition.y, result)) {
            return newPosition;
        } else {
            return new Position(-1, -1, "right");
        }
    }

    private boolean validate(int x, int y, int[][] result) {
        int n = result.length;
        if (x < 0 || x>= n || y < 0 || y >= n) {
           return false;
        }
        if (result[x][y] > 0) {
            return false;
        }
        return true;
    }
}

class Position {
    int x;
    int y;
    String direction;

    public Position(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}