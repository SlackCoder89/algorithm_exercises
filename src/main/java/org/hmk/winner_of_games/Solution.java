package org.hmk.winner_of_games;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean winnerOfGame(String colors) {
        Queue<Count> queueA = new LinkedList<>();
        Queue<Count> queueB = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < colors.length(); ++i) {
            if (colors.charAt(i) == 'A') {
                count++;
            } else {
                if (count >= 3) {
                    queueA.offer(new Count(count));
                }
                count = 0;
            }
        }
        if (count >= 3) {
            queueA.offer(new Count(count));
        }
        count = 0;
        for (int i = 0; i < colors.length(); ++i) {
            if (colors.charAt(i) == 'B') {
                count++;
            } else {
                if (count >= 3) {
                    queueB.offer(new Count(count));
                }
                count = 0;
            }
        }
        if (count >= 3)
            queueB.offer(new Count(count));

        boolean isAsTurn = true;
        while (true) {
            if (isAsTurn) {
                if (queueA.isEmpty()) {
                    return false;
                } else {
                    Count c = queueA.peek();
                    c.c--;
                    if (c.c < 3) {
                        queueA.poll();
                    }
                }
                isAsTurn = false;
            } else {
                if (queueB.isEmpty()) {
                    return true;
                } else {
                    Count c = queueB.peek();
                    c.c--;
                    if (c.c < 3) {
                        queueB.poll();
                    }
                }
                isAsTurn = true;
            }
        }
    }
}

class Count {
    int c;

    public Count(int c) {
        this.c = c;
    }
}
