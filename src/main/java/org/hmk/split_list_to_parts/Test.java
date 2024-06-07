package org.hmk.split_list_to_parts;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.splitListToParts(ListNode.build(new int[]{1, 2, 3}), 5)));
        System.out.println(Arrays.toString(solution.splitListToParts(ListNode.build(new int[]{1,2,3,4,5,6,7,8,9,10}), 3)));
    }
}
