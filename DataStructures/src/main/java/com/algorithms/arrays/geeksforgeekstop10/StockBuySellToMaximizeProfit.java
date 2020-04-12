package com.algorithms.arrays.geeksforgeekstop10;

/*
https://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/
https://www.geeksforgeeks.org/stock-buy-sell/

Stock Buy Sell to Maximize Profit
The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling
in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned
by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted
in decreasing order, then profit cannot be earned at all.

Approach:
1) Iterate through array only once, if see a dip, buy, see a peak, sell.
2) Dip will mean lower value of current element compared to its neighbors. Peak will be vise versa
BigO: O(n)
 */

public class StockBuySellToMaximizeProfit {

    public static void main(String[] args) {

        int [] price = {100, 180, 260, 310, 40, 535, 695};
        int netProfit = profit(price);

        System.out.println("Net profit: " + netProfit);
    }



    private static int profit(int[] price) {

        int profit = 0;

        if (price == null || price.length == 1) return profit;

        int len = price.length;

        for (int i=0; i<len; i++) {

            // Buy situation, i.e., whenever there is a dip, its time to buy
            if ((i==0 || price[i] < price[i-1]) && (i==len-1 || price[i] < price[i+1])) {
                // Time to buy since it is a dip here
                profit -= price[i];
            }

            // Sell situation, i.e., whenever there is a peak, its time to sell
            if ((i==0 || price[i] > price[i-1]) && (i==len-1) || price[i] > price[i+1]) {
                // Time to buy since it is a dip here
                profit += price[i];
            }
        }

        return profit;
    }


}
