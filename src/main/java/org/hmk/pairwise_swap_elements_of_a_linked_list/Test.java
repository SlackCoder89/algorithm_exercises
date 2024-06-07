package org.hmk.pairwise_swap_elements_of_a_linked_list;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pairwiseSwap(build(new int[]{
                1, 2, 2, 4, 5, 6, 7, 8
        })));
        System.out.println(solution.pairwiseSwap(build(new int[]{
                1, 3, 4, 7, 9, 10, 1
        })));
    }

    private static Node build(int[] ints) {
        Node head = new Node(ints[0]);
        Node cur = head;
        for (int i = 1; i < ints.length; ++i) {
            cur.next = new Node(ints[i]);
            cur = cur.next;
        }
        return head;
    }
}
