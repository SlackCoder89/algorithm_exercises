package org.hmk.langtons_ant;

public class Solution {
}

class Grid {
    private boolean[][] grid;
    private Ant ant = new Ant();

    public Grid() {
        grid = new boolean[1][1];
    }

    private void copyWithShift(boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftColumn) {
        for (int r = 0; r < oldGrid.length; ++r) {
            for (int c = 0; c < oldGrid[0].length; ++c) {
                newGrid[r + shiftRow][c + shiftColumn] = oldGrid[r][c];
            }
        }
    }

    private void ensureFit(Position position) {
        int shiftRow = 0;
        int shiftColumn = 0;

        int numRows = grid.length;
        if (position.row < 0) {
            shiftRow = numRows;
            numRows *= 2;
        } else if (position.row >= numRows) {
            numRows *= 2;
        }

        int numColumns = grid[0].length;
        if (position.column < 0) {
            shiftColumn = numColumns;
            numColumns *= 2;
        } else if (position.column >= numColumns) {
            numColumns *= 2;
        }
        
        if (numRows != grid.length || numColumns != grid[0].length) {
            boolean[][] newGrid = new boolean[numRows][numColumns];
            copyWithShift(grid, newGrid, shiftRow, shiftColumn);
            ant.adjustPosition(shiftRow, shiftColumn);
            grid = newGrid;
        }
    }
    
    private void flip(Position position) {
        int row = position.row;
        int column = position.column;
        grid[row][column] = !grid[row][column];
    }
    
    public void move() {
        ant.turn(grid[ant.position.row][ant.position.column]);
        flip(ant.position);
        ant.move();
        ensureFit(ant.position);
    }
}

class Ant {
    Position position = new Position(0, 0);
    Orientation orientation = Orientation.right;

    public void adjustPosition(int shiftRow, int shiftColumn) {
        position.row += shiftRow;
        position.column += shiftColumn;
    }

    public void turn(boolean clockWise) {
        orientation = orientation.getTurn(clockWise);
    }

    public void move() {
        switch (orientation) {
            case left:
                position.column--;
                break;
            case right:
                position.column++;
                break;
            case up:
                position.row--;
                break;
            case down:
                position.row++;
                break;
        }
    }
}

enum Orientation {
    left, up, right, down;

    Orientation getTurn(boolean clockwise) {
        if (this == left) {
            return clockwise ? up : down;
        } else if (this == up) {
            return clockwise ? right : left;
        } else if (this == right) {
            return clockwise ? down : up;
        } else {
            return clockwise ? left : right;
        }
    }
}

class Position {
    int row;
    int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position clone() {
        return new Position(row, column);
    }
}