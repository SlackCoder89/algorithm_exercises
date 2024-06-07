package org.hmk.add_minimum;

public class Solution {
    public int addMinimum(String word) {
        int index = 0;
        int minimum = 0;
        while (index < word.length()) {
            Position p = nextPosition(word, index);
            index = p.offset;
            minimum += p.addition;
        }
        return minimum;
    }

    private Position nextPosition(String word, int index) {
        switch (word.charAt(index)) {
            case 'a':
                return previousWithA(word, index + 1);
            case 'b':
                Position p = previousWithB(word, index + 1);
                return p;
            case 'c':
                return new Position(index + 1, 2);
        }
        throw new RuntimeException();
    }

    private Position previousWithB(String word, int index) {
        if (index >= word.length()) {
            return new Position(index, 2);
        }
        if (word.charAt(index) == 'c') {
            return new Position(index + 1, 1);
        }
        if (word.charAt(index) == 'a') {
            return new Position(index, 2);
        }
        if (word.charAt(index) == 'b') {
            return new Position(index, 2);
        }
        return new Position(index + 1, 2);

    }

    private Position previousWithA(String word, int index) {
        if (index >= word.length()) {
            return new Position(index, 2);
        }
        switch (word.charAt(index)) {
            case 'b':
                return previousWithAB(word, index + 1);
            case 'c':
                return new Position(index + 1, 1);
            case 'a':
                return new Position(index, 2);
        }
        throw new RuntimeException();
    }

    private Position previousWithAB(String word, int index) {
        if (index >= word.length()) {
            return new Position(index, 1);
        }
        if (word.charAt(index) == 'c') {
            return new Position(index + 1, 0);
        }
        if (word.charAt(index) == 'a' ) {
            return new Position(index, 1);
        }
        if (word.charAt(index) == 'b') {
            return new Position(index, 1);
        }
        return new Position(index + 1, 1);
    }
}

class Position {
    int offset;
    int addition;

    public Position(int offset, int addition) {
        this.offset = offset;
        this.addition = addition;
    }
}
