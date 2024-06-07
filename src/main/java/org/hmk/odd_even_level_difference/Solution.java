package org.hmk.odd_even_level_difference;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int getLevelDiff(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int currentCount = 1;
        int sum = 0;
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            int nextCount = 0;
            while (currentCount > 0) {
                Node n = queue.poll();
                if (isOdd) {
                    sum += n.data;
                } else {
                    sum -= n.data;
                }
                if (n.left != null) {
                    queue.offer(n.left);
                    nextCount++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    nextCount++;
                }
                currentCount--;
            }
            currentCount = nextCount;
            isOdd = !isOdd;
        }
        return sum;
    }
}
