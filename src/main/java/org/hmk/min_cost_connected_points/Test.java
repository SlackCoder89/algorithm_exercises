package org.hmk.min_cost_connected_points;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.minCostConnectPoints(new int[][]{
//                {0,0},{2,2},{3,10},{5,2},{7,0}
//        }));
//
//        System.out.println(solution.minCostConnectPoints(new int[][]{
//                {3,12},{-2,5},{-4,1}
//        }));

        System.out.println(solution.minCostConnectPoints(new int[][]{
                {7,18},{-15,19},{-18,-15},{-7,14},{4,1},{-6,3}
        }));
    }
}
