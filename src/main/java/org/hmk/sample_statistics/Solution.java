package org.hmk.sample_statistics;

public class Solution {
    public double[] sampleStats(int[] count) {
        double minimum = 0;
        double maximum = 0;
        double mean = 0;
        double median = 0;
        double mode = 0;
        for (int i = 0; i < count.length; ++i) {
            if (count[i] > 0) {
                minimum = i;
                break;
            }
        }
        for (int i = count.length - 1; i >= 0; --i) {
            if (count[i] > 0) {
                maximum = i;
                break;
            }
        }
        long amount = 0;
        long totalAmount = 0;
        for (int i = 0; i < count.length; ++i) {
            amount += count[i];
            totalAmount += (long) i * count[i];
        }
        mean = (double)totalAmount / amount;
        if (amount % 2 == 1) {
            long index = amount / 2 + 1;
            long tmpAmount = 0;
            for (int i = 0; i < count.length; ++i) {
                tmpAmount += count[i];
                if (tmpAmount >= index) {
                    median = i;
                    break;
                }
            }
        } else {
            long index = amount / 2;
            boolean findNext = false;
            long tmpAmount = 0;
            long first = 0;
            long next = 0;
            for (int i = 0; i < count.length; ++i) {
                tmpAmount += count[i];
                if (!findNext) {
                    if (tmpAmount == index) {
                        first = i;
                        findNext = true;
                    } else if (tmpAmount > index) {
                        median = i;
                        break;
                    }
                } else {
                    if (count[i] > 0) {
                        next = i;
                        median = ((double) first + next) / 2;
                        break;
                    }
                }
            }
        }
        long mostAmount = 0;
        for (int i = 0; i < count.length; ++i) {
            if (count[i] > mostAmount) {
                mostAmount = count[i];
                mode = i;
            }
        }
        return new double[]{minimum, maximum, mean, median, mode};
    }
}
