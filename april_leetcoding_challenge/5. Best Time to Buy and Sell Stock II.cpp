/*
Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
*/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit=0,range = prices.size();
        if(range==0)
            return profit;
        int i =0,buy=0,sell=0;
        while(i<range-1){
            while(i<range-1 && prices[i]>=prices[i+1])
                i++;
            buy = prices[i];
            while(i<range-1 && prices[i]<=prices[i+1])
                i++;
            sell = prices[i];
            profit+= sell-buy;
        }
        return profit;
    }
};
