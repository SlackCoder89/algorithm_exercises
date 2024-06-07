package org.hmk.best_closing_time;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int bestClosingTime(String customers) {
        List<Time> times = new ArrayList<>();
        times.add(new Time(0, 0, 0, 0));
        for (int i = 1; i < customers.length(); ++i) {
            if (customers.charAt(i - 1) == 'Y') {
                times.add(new Time(times.get(i - 1).nBefore, times.get(i - 1).yBefore + 1, 0, 0));
            } else {
                times.add(new Time(times.get(i - 1).nBefore + 1, times.get(i - 1).yBefore, 0, 0));
            }
        }
        times.add(new Time(times.get(times.size() - 1).nBefore, times.get(times.size() - 1).yBefore, 0, 0));

//        if (customers.charAt(customers.length() - 1) == 'Y') {
//            times.get(times.size() - 1).yAfter++;
//        } else {
//            times.get(times.size() - 1).nAfter++;
//        }

        for (int i = customers.length(); i > 0; --i) {
            if (customers.charAt(i - 1) == 'Y') {
                times.get(i - 1).yAfter = times.get(i).yAfter + 1;
                times.get(i - 1).nAfter = times.get(i).nAfter;
            } else {
                times.get(i - 1).yAfter = times.get(i).yAfter;
                times.get(i - 1).nAfter = times.get(i).nAfter + 1;
            }
        }

        int res = 0;
        int p = Integer.MAX_VALUE;
        for (int i = 0; i < times.size(); ++i) {
            int tmp = calPenalty(times.get(i));
            if (tmp < p) {
                p = tmp;
                res = i;
            }
        }
        return res;
    }

    private int calPenalty(Time time) {
        return time.nBefore + time.yAfter;
    }
}

class Time {
    int nBefore;
    int yBefore;
    int nAfter;
    int yAfter;

    public Time(int nBefore, int yBefore, int nAfter, int yAfter) {
        this.nBefore = nBefore;
        this.yBefore = yBefore;
        this.nAfter = nAfter;
        this.yAfter = yAfter;
    }
}
