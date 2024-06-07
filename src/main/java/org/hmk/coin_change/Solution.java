package org.hmk.coin_change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Map<int[], Integer> inputs = new HashMap<>();
//        inputs.put(new int[]{1,2,5}, 11);
//        inputs.put(new int[]{2}, 3);
//        inputs.put(new int[]{1}, 0);
//        inputs.put(new int[]{2, 5, 10, 1}, 27);
        inputs.put(new int[]{186,419,83,408}, 6249);

        Solution solution = new Solution();
        for (Map.Entry<int[], Integer> entry : inputs.entrySet()) {
            System.out.println(Arrays.toString(entry.getKey()) + ": " + solution.coinChange(entry.getKey(), entry.getValue()));
        }
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        boolean finished = false;
        int[] counts = new int[coins.length];
        int[] status = new int[coins.length];
        int curAmount = 0;
        int curIndex = coins.length - 1;

        if (curAmount < amount) {
            curIndex = coins.length - 1;
            status[curIndex] = 1;
        } else if (curAmount > amount) {
            return -1;
        } else if (curAmount == amount) {
            return 0;
        }

        while (true) {
            curAmount += coins[curIndex];
            counts[curIndex]++;
            if (curAmount < amount) {
                continue;
            } else if (curAmount > amount) {
                curAmount -= coins[curIndex];
                counts[curIndex]--;
                curIndex--;
                if (curIndex < 0) {
                    counts[0] = 0;
                    status[0] = 0;
                    for (int i = 1; i < coins.length; ++i) {
                        if (counts[i] > 0) {
                            curIndex = i - 1;
                            counts[i]--;
                            status[curIndex] = 1;
                        } else {
                            status[i] = 0;
                        }
                    }
                    if (curIndex == -1) {
                        break;
                    }
                }
            } else {
                break;
            }
        }

        int count = -1;
        int tmpCount = 0;
        for (int c : counts) {
            tmpCount += c;
        }
        if (tmpCount > 0) {
            count = tmpCount;
        }
        return count;
    }
}

class Status {
    boolean isIncreased;
    boolean triedNext;

    public Status(boolean isIncreased, boolean triedNext) {
        this.isIncreased = isIncreased;
        this.triedNext = triedNext;
    }
}