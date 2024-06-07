package org.hmk.subtraction_in_linked_list;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subLinkedList(buildNode(new int[]{
                1,0,0
        }), buildNode(new int[]{
                1,2
        })));
        System.out.println(s.subLinkedList(buildNode(new int[]{
                0,0,6,3
        }), buildNode(new int[]{
                7,1,0
        })));
    }

    private static Node buildNode(int[] nums) {
        Node res = null;
        for (int i = nums.length - 1; i >= 0; --i) {
            Node pre = new Node(nums[i]);
            pre.next = res;
            res = pre;
        }
        return res;
    }
}
