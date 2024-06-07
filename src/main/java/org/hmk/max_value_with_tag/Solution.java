package org.hmk.max_value_with_tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        List<Value> valueList = new ArrayList<>();
        for (int i = 0; i < values.length; ++i) {
            valueList.add(new Value(values[i], labels[i]));
        }

        valueList.sort((o1, o2) -> o2.value - o1.value);
        Map<Integer, Integer> labelCount = new HashMap<>();
        int sum = 0;
        int numCount = 0;
        for (Value value : valueList) {
            if (numCount >= numWanted) {
                break;
            }
            if (labelCount.getOrDefault(value.tag, 0)  < useLimit) {
                sum += value.value;
                labelCount.put(value.tag, labelCount.getOrDefault(value.tag, 0) + 1);
                numCount++;
            }
        }
        return sum;
    }
}

class Value {
    int value;
    int tag;

    public Value(int value, int tag) {
        this.value = value;
        this.tag = tag;
    }
}
