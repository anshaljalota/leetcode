/*

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

*/

class Solution {
    public int maxProfit(int[] prices) {
        int i,range=prices.length,profitL=0,profitR=0,profit=0;
        if(range==0)
            return 0;
        int min = prices[0];
        int []left = new int[range];
        int []right = new int[range];
        for(i=0;i<range;i++){
            min = Math.min(min,prices[i]);
            profitL = Math.max(profitL,prices[i]-min);
            left[i] = profitL;
        }
        int max = prices[range-1];
        for(i=range-1;i>=0;i--){
            max = Math.max(max,prices[i]);
            profitR = Math.max(profitR,max-prices[i]);
            right[i] = profitR;
        }
        for(i=0;i<range;i++){
            profit = Math.max(profit,left[i]+right[i]);
        }
        return profit;
    }
}
