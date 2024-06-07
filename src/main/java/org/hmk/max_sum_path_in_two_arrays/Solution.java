package org.hmk.max_sum_path_in_two_arrays;

import java.util.HashMap;
import java.util.Map;

/*
sum = 35
isStarFromA false
index 0
===
sumB =
sumA = 34
aCache 2 -> 29
bCache 2 -> 29
bToAMap 2 -> 2,
aToBMap 2 -> 2,
ar2
ar1
 */
public class Solution {
    int maxPathSum(int ar1[], int ar2[]) {
        // find common elements
        Map<Integer, Integer> aToBMap = new HashMap<>();
        Map<Integer, Integer> bToAMap = new HashMap<>();
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < ar1.length && bIndex < ar2.length) {
            if (ar1[aIndex] == ar2[bIndex]) {
                aToBMap.put(aIndex, bIndex);
                bToAMap.put(bIndex, aIndex);
                aIndex++;
                bIndex++;
            } else if (ar1[aIndex] < ar2[bIndex]) {
                aIndex++;
            } else {
                bIndex++;
            }
        }

        Map<Integer, Integer> aCache = new HashMap<>();
        Map<Integer, Integer> bCache = new HashMap<>();
        // find max path sum start from the first array
        int sumA = doMaxPathSum(ar1, ar2, 0, true, aToBMap, bToAMap, aCache, bCache);
        // find max path sum start from the second array
        int sumB = doMaxPathSum(ar1, ar2, 0, false, aToBMap, bToAMap, aCache, bCache);
        // return max path sum
        return Math.max(sumA, sumB);
    }

    private int doMaxPathSum(int[] ar1, int[] ar2, int index, boolean isStartFromA, Map<Integer, Integer> aToBMap, Map<Integer, Integer> bToAMap, Map<Integer, Integer> aCache, Map<Integer, Integer> bCache) {
        if (isStartFromA && aCache.containsKey(index)) {
            return aCache.get(index);
        } else if (!isStartFromA && bCache.containsKey(index)) {
            return bCache.get(index);
        }

        if (isStartFromA) {
            if (index >= ar1.length) {
                return 0;
            }
            if (aToBMap.containsKey(index)) {
                int tmp1 = ar1[index] + doMaxPathSum(ar1, ar2, index + 1, true, aToBMap, bToAMap, aCache, bCache);
                int tmp2 = ar2[aToBMap.get(index)] + doMaxPathSum(ar1, ar2, aToBMap.get(index) + 1, false, aToBMap, bToAMap, aCache, bCache);
                int sum = Math.max(tmp1, tmp2);
                aCache.put(index, sum);
                bCache.put(aToBMap.get(index), sum);
                return sum;
            } else {
                int sum = ar1[index] + doMaxPathSum(ar1, ar2, index + 1, true, aToBMap, bToAMap, aCache, bCache);
                aCache.put(index, sum);
                return sum;
            }
        } else {
            if (index >= ar2.length) {
                return 0;
            }
            if (bToAMap.containsKey(index)) {
                int tmp2 = ar2[index] + doMaxPathSum(ar1, ar2, index + 1, false, aToBMap, bToAMap, aCache, bCache);
                int tmp1 = ar1[index] + doMaxPathSum(ar1, ar2, bToAMap.get(index) + 1, true, aToBMap, bToAMap, aCache, bCache);
                int sum = Math.max(tmp1, tmp2);
                bCache.put(index, sum);
                aCache.put(bToAMap.get(index), sum);
                return sum;
            } else {
                int sum = ar2[index] + doMaxPathSum(ar1, ar2, index + 1, false, aToBMap, bToAMap, aCache, bCache);
                bCache.put(index, sum);
                return sum;
            }
        }
    }
}
