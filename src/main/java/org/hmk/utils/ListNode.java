package org.hmk.utils;

public class ListNode {
      public int val;
      public ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
            return val + ", " + next;
      }

      public static ListNode build(int[] array) {
            ListNode head = new ListNode(array[0]);
            ListNode pre = head;
            for (int i = 1; i < array.length; ++i) {
                  ListNode cur = new ListNode(array[i]);
                  pre.next = cur;
                  pre = cur;
            }
            return head;
      }
}
