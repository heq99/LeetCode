package com.qiang.leetcode.top_interview_questions.array;

/*
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * 
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * 
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e., max profit = 0.
 * 
 * Constraints:
 *     1 <= prices.length <= 3 * 10^4
 *     0 <= prices[i] <= 10^4
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