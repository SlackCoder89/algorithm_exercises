package org.hmk.sqrt;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; ++i) {
            int tmp = i * i;
            solution.sqrt(tmp);
            System.out.printf("input: %d, count: %d, log: %f\n", tmp, solution.count, Math.log(tmp) / Math.log(2));
        }
    }
}
