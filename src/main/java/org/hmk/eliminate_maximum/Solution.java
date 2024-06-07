package org.hmk.eliminate_maximum;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        Queue<Monster> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.mins));
        for (int i = 0; i < dist.length; ++i) {
            queue.offer(new Monster((double)dist[i] / speed[i], dist[i], speed[i]));
        }

        int count = 0;
        int mins = 0;
        while (!queue.isEmpty()) {
            Monster monster = queue.poll();
            if (monster.dist - mins * monster.speed > 0) {
                count++;
                mins++;
            } else {
                return count;
            }
        }
        return count;
    }
}

class Monster {
    double mins;
    int dist;
    int speed;

    public Monster(double mins, int dist, int speed) {
        this.mins = mins;
        this.dist = dist;
        this.speed = speed;
    }
}
