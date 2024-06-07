package org.hmk.interval_merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] inter : intervals) {
            intervalList.add(new Interval(inter[0], inter[1]));
        }
        intervalList.sort(Comparator.comparingInt(o -> o.start));

        int pre = 0;
        for (int cur = 1; cur < intervalList.size(); ++cur) {
            if (intervalList.get(pre).end >= intervalList.get(cur).start) {
                Interval inter = new Interval(intervalList.get(pre).start, Math.max(intervalList.get(pre).end, intervalList.get(cur).end));
                intervalList.add(cur + 1, inter);
                intervalList.remove(cur);
                intervalList.remove(pre);
                --cur;
            } else {
                pre = cur;
            }
        }

        int[][] res = new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); ++i) {
            res[i][0] = intervalList.get(i).start;
            res[i][1] = intervalList.get(i).end;
        }
        return res;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
