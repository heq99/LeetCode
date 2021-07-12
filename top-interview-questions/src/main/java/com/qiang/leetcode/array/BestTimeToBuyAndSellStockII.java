package com.qiang.leetcode.array;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
 */
public class BestTimeToBuyAndSellStockII {

    public int recursiveCalc(int[] prices, int pos) {
        int max = 0;
        for (int i=pos; i<prices.length-1; i++) {
            int buy = prices[i];
            int maxProfit = 0;
            for (int j=i+1; j<prices.length; j++) {
                int sell = prices[j];
                if (buy<sell) {
                    int profit = recursiveCalc(prices, j+1) + sell - buy;
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
            if (maxProfit > max) {
                max = maxProfit;
            }
        }
        return max;
    }

    public int onePassCalc(int[] prices) {
        int profit = 0;
        for (int i=0; i<prices.length-1; i++) {
            if (prices[i]<prices[i+1]) {
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

    public static void main( String[] args ) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();
        System.out.println("Max profit by recursive calculation: " + solution.recursiveCalc(prices, 0));

        System.out.println("Max profit by one pass calculation: " + solution.onePassCalc(prices));
    }

}