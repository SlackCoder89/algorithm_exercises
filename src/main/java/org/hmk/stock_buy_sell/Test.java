package org.hmk.stock_buy_sell;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.stockBuySell(new int[]{
                100,180,260,310,40,535,695
        }, 7));
        System.out.println(solution.stockBuySell(new int[]{
                4,2,2,2,4
        }, 5));
    }
}
