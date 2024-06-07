package org.hmk.max_dist_to_closest;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        System.out.println(solution.maxDistToClosest(new int[]{1,0,0,0}));
        System.out.println(solution.maxDistToClosest(new int[]{0,1}));
    }
}
