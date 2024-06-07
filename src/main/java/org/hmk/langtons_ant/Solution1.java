package org.hmk.langtons_ant;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

}

class Board {
    Set<Position> whites = new HashSet<>();
    Ant ant = new Ant();
    Position topLeftCorner = new Position(0, 0);
    Position bottomRightCorner = new Position(0, 0);

    void move() {
        ant.turn(isWhite(ant.position));
        flip(ant.position);
        ant.move();
        ensureFit(ant.position);
    }

    private void ensureFit(Position position) {
        int row = position.row;
        int column = position.column;

        topLeftCorner.row = Math.min(topLeftCorner.row, row);
        topLeftCorner.column = Math.min(topLeftCorner.column, column);

        bottomRightCorner.row = Math.max(bottomRightCorner.row, row);
        bottomRightCorner.column = Math.max(bottomRightCorner.column, column);
    }

    private void flip(Position position) {
        if (whites.contains(position)) {
            whites.remove(position);
        } else {
            whites.add(position.clone());
        }
    }

    private boolean isWhite(Position position) {
        return whites.contains(position);
    }
}
