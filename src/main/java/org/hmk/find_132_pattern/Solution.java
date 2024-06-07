package org.hmk.find_132_pattern;

import java.util.LinkedList;
import java.util.ListIterator;

public class Solution {
    public boolean find132pattern(int[] nums) {
        LinkedList<Range> ranges = new LinkedList<>();
        for (int num : nums) {
            if (ranges.isEmpty()) {
                ranges.add(new Range(num, num));
                continue;
            }
            ListIterator<Range> iterator = ranges.listIterator();
            while (iterator.hasNext()) {
                Range cur = iterator.next();
                if (cur.start < num && num < cur.end) {
                    return true;
                } else if (cur.start >= num) {
                    iterator.previous();
                    Range pre = null;
                    if (iterator.hasPrevious()) {
                        pre = iterator.previous();
                    }
                    while (iterator.hasPrevious()) {
                        iterator.remove();
                        pre = iterator.previous();
                    }
                    if (pre != null) {
                        pre.end = num;
                    } else {
                        iterator.add(new Range(num, num));
                    }
                    break;
//                } else if ((cur.start != cur.end) && (num == cur.start || num == cur.end)) {
//                    break;
                } else if (cur.end == num) {
                    Range pre = null;
                    if (iterator.hasPrevious()) {
                        pre = iterator.previous();
                    }
                    while (iterator.hasPrevious()) {
                        iterator.remove();
                        pre = iterator.previous();
                    }
                    if (pre != null) {
                        pre.end = num;
                    } else {
                        iterator.add(new Range(num, num));
                    }
                    break;
                } else if (!iterator.hasNext()) {
                    Range first = ranges.getFirst();
                    ranges.clear();
                    ranges.add(new Range(first.start, num));
                }
            }
        }
        return false;
    }
}

class Range {
    int start;
    int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
