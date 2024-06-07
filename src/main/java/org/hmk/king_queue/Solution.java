package org.hmk.king_queue;

import java.util.*;

public class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] queen : queens) {
            if (validate(queen, queens, king)) {
                res.add(Arrays.asList(queen[0], queen[1]));
            }
        }
        return res;
    }

    private boolean validate(int[] position, int[][] queens, int[] king) {
        List<Integer>[] queenList = new List[queens.length];
        for (int i = 0; i < queens.length; ++i) {
            queenList[i] = Arrays.asList(queens[i][0], queens[i][1]);
        }

        if (position[0] == king[0]) {
            Set<List<Integer>> obstacles = new HashSet<>();
            int start = Math.min(position[1], king[1]) + 1;
            int end = Math.max(position[1], king[1]);
            for (int y = start; y < end; ++y) {
                obstacles.add(Arrays.asList(position[0], y));
            }
            return !contains(obstacles, queenList);
        } else if (position[1] == king[1]) {
            Set<List<Integer>> obstacles = new HashSet<>();
            int start = Math.min(position[0], king[0]) + 1;
            int end = Math.max(position[0], king[0]);
            for (int x = start; x < end; ++x) {
                obstacles.add(Arrays.asList(x, position[1]));
            }
            return !contains(obstacles, queenList);
        } else if (Math.abs(position[0] - king[0]) == Math.abs(position[1] - king[1])) {
            int startX = 0;
            int startY = 0;
            int endX = 0;
            int endY = 0;
            Set<List<Integer>> obstacles = new HashSet<>();
            if (position[0] < king[0] && position[1] < king[1]) {
                startX = position[0] + 1;
                startY = position[1] + 1;
                endX = king[0];
                endY = king[1];
                for (int x = startX, y = startY; x < endX && y < endY; ++x, ++y) {
                    obstacles.add(Arrays.asList(x, y));
                }
            } else if (king[0] < position[0] && king[1] < position[1]) {
                startX = king[0] + 1;
                startY = king[1] + 1;
                endX = position[0];
                endY = position[1];
                for (int x = startX, y = startY; x < endX && y < endY; ++x, ++y) {
                    obstacles.add(Arrays.asList(x, y));
                }
            } else if (position[0] < king[0]) {
                startX = position[0] + 1;
                startY = position[1] - 1;
                endX = king[0];
                endY = king[1];
                for (int x = startX, y = startY; x < endX && y > endY; ++x, --y) {
                    obstacles.add(Arrays.asList(x, y));
                }
            } else {
                startX = king[0] + 1;
                startY = king[1] - 1;
                endX = position[0];
                endY = position[1];
                for (int x = startX, y = startY; x < endX && y > endY; ++x, --y) {
                    obstacles.add(Arrays.asList(x, y));
                }
            }
            return !contains(obstacles, queenList);
        }
        return false;
    }

    private boolean contains(Set<List<Integer>> obstacles, List<Integer>[] queens) {
        for (List<Integer> queue : queens) {
            if (obstacles.contains(queue)) {
                return true;
            }
        }
        return false;
    }
}
