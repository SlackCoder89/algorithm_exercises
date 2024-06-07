package org.hmk.stock_price;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {
    List<Integer> prices = new ArrayList<>();
    public StockSpanner() {

    }

    public int next(int price) {
        int count = 0;
        prices.add(0, price);
        for (int p : prices) {
            if (p <= price) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
