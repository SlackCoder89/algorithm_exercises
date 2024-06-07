package org.hmk.find_median_in_a_stream;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    static Queue<Integer> min = new PriorityQueue<>();
    static Queue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static int count = 0;
    public static void insertHeap(int x)
    {
        min.offer(x);
        balanceHeaps();
        count++;
    }

    //Function to balance heaps.
    public static void balanceHeaps()
    {
        while (!min.isEmpty() && !max.isEmpty() && min.peek() < max.peek()) {
            max.offer(min.poll());
        }

        while (min.size() > max.size()) {
            max.offer(min.poll());
        }
        if (max.size() > min.size()) {
            min.offer(max.poll());
        }
    }

    //Function to return Median.
    public static double getMedian()
    {
        if (count % 2 == 0) {
            return (min.peek().doubleValue() + max.peek()) / 2;
        } else {
            return min.peek();
        }
    }
}
