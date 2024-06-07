package org.hmk.minimum_distance_between_two_numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int minDist(int a[], int n, int x, int y) {
        List<Integer> xIndex = new ArrayList<>();
        List<Integer> yIndex = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (a[i] == x) {
                xIndex.add(i);
            }
            if (a[i] == y) {
                yIndex.add(i);
            }
        }

        int xi = 0;
        int yi = 0;
        int res = Integer.MAX_VALUE;
        while (xi < xIndex.size() && yi < yIndex.size()) {
            res = Math.min(res, Math.abs(xIndex.get(xi) - yIndex.get(yi)));
            if (xIndex.get(xi) < yIndex.get(yi)) {
                xi++;
            } else {
                yi++;
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        } else {
            return res;
        }
    }
}
