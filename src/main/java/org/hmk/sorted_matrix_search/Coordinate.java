package org.hmk.sorted_matrix_search;

public class Coordinate implements Cloneable {
    public int row, column;
    public Coordinate(int r, int c) {
        row = r;
        column = c;
    }
    public boolean inbounds(int[][] matrix) {
        return row >= 0 && column >= 0 && row < matrix.length && column < matrix[0].length;
    }
    public boolean isBefore(Coordinate p) {
        return row <= p.row && column <= p.column;
    }
    public Object clone() {
        return new Coordinate(row, column);
    }
    public void setToAverage(Coordinate min, Coordinate max) {
        row = (min.row + max.row) / 2;
        column = (min.column + max.column) / 2;
    }
}
