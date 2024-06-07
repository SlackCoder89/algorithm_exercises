package org.hmk.delete_duplicates;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.deleteDuplicates(generateList(new int[]{1,2,3,3,4,4,5})));
        System.out.println(solution.deleteDuplicates(generateList(new int[]{1,1,1,2,3})));
    }

    static ListNode generateList(int[] nums) {
        ListNode head = null;
        ListNode pre = null;
        ListNode cur = null;
        for (int n : nums) {
            cur = new ListNode(n);
            if (pre != null) {
                pre.next = cur;
            } else {
                head = cur;
            }
            pre = cur;
        }
        return head;
    }
}
