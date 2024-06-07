package org.hmk.random_list_copy;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.copyRandomList(Node.build(new int[][]{
                {7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}
        })));
    }
}
