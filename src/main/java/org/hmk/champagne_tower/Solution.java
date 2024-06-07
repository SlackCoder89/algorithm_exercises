package org.hmk.champagne_tower;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<double[]> tower = new ArrayList<>();
        boolean isContinue = false;
        int index = 0;
        double[] zero = new double[]{poured};
        tower.add(zero);
        if (tower.get(0)[0] > 1) {
            isContinue = true;
        }
        while (isContinue) {
            double[] nextRow = new double[index + 1 + 1];
            tower.add(nextRow);
            boolean tmpContinue = false;
            for (int i = 0; i < tower.get(index).length; ++i) {
                if (tower.get(index)[i] <= 1) {
                    continue;
                }
                double extra = tower.get(index)[i] - 1;
                tower.get(index)[i] = 1;

                tower.get(index + 1)[i] += extra / 2;
                if (tower.get(index + 1)[i] > 1) {
                    tmpContinue = true;
                }
                tower.get(index + 1)[i + 1] += extra / 2;
                if (tower.get(index + 1)[i + 1] > 1) {
                    tmpContinue = true;
                }
            }
            isContinue = tmpContinue;
            ++index;
            if (index >= query_row) {
                break;
            }
        }
        if (query_row < tower.size() && query_glass < tower.get(query_row).length) {
            return Math.min(tower.get(query_row)[query_glass], 1);
        } else {
            return 0;
        }
    }
}
