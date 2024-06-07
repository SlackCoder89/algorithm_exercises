package org.hmk.seat_manager;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeatManager {
    Queue<Integer> unreserved = new PriorityQueue<>();
    public SeatManager(int n) {
        for (int i = 1; i <= n; ++i) {
            unreserved.add(i);
        }
    }

    public int reserve() {
        return unreserved.poll();
    }

    public void unreserve(int seatNumber) {
        unreserved.add(seatNumber);
    }
}
