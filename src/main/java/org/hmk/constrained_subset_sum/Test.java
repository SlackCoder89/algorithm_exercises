package org.hmk.constrained_subset_sum;

public class Test {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        System.out.println(solution.constrainedSubsetSum(new int[]{10,2,-10,5,20}, 2));
//        System.out.println(solution.constrainedSubsetSum(new int[]{-1,-2,-3}, 1));
//        System.out.println(solution.constrainedSubsetSum(new int[]{10,-2,-10,-5,20}, 2));

//        String s = Files.readString(Path.of(args[0]));
//        String[] strs = s.split(",");
//        int[] ints = new int[strs.length];
//        for (int i = 0; i < strs.length; ++i) {
//            ints[i] = Integer.parseInt(strs[i]);
//        }
//        System.out.println(solution.constrainedSubsetSum(ints, 58823));
    }
}
