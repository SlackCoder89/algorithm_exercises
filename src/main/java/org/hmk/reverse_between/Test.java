package org.hmk.reverse_between;

import utils.ListNode;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverseBetween(ListNode.build(new int[]{1,2,3,4,5}), 2, 4));
        System.out.println(solution.reverseBetween(ListNode.build(new int[]{5}), 1, 1));
    }
}
