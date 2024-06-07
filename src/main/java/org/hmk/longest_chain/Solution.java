package org.hmk.longest_chain;

import java.util.*;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        List<Chain> chainList = new ArrayList<>();
        for (int[] pair : pairs) {
            chainList.add(new Chain(pair[0], pair[1]));
        }

        chainList.sort(Comparator.comparingInt(o -> o.start));

        Map<Integer, Integer> cache = new HashMap<>();
        int l1 = findLongestChainStartWith(chainList, 1, cache);
        int index = findStartIndex(chainList, 0);
        int l2 = findLongestChainStartWith(chainList, index, cache) + 1;
        return Math.max(l1, l2);
    }

    private int findLongestChainStartWith(List<Chain> chainList, int index, Map<Integer, Integer> cache) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (index >= chainList.size()) {
            int ret = 0;
            cache.put(index, ret);
            return ret;
        }

        int l1 = findLongestChainStartWith(chainList, index + 1, cache);
        int nextIndex = findStartIndex(chainList, index);
        int l2 = findLongestChainStartWith(chainList, nextIndex, cache) + 1;
        int ret = Math.max(l1 , l2);
        cache.put(index, ret);
        return ret;
    }

    private int findStartIndex(List<Chain> chainList, int index) {
        int ret = chainList.size();
        for (int i = index + 1; i < chainList.size(); ++i) {
            if (chainList.get(i).start > chainList.get(index).end) {
                return i;
            }
        }
        return ret;
    }
}

class Chain {
    int start;
    int end;

    public Chain(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
