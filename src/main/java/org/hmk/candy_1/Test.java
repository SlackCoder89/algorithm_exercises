package org.hmk.candy_1;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "1";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        String base36 = new BigInteger(1, bytes).toString(36);

        System.out.println(solution.candy(new int[]{1,0,2}));
        System.out.println(solution.candy(new int[]{1,2,2}));
    }
}
