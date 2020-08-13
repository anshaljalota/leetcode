/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
*/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int range = prices.size();
        if(range<2)
            return 0;
        if(range==2){
            return prices[1]<prices[0]?0: prices[1]-prices[0];
        }
        vector<vector<int>> dp(range,vector<int>(2,0));
        dp[0][0]=-1*prices[0];
        dp[0][1]=0;
        dp[1][0]=-1*min(prices[1],prices[0]);
        dp[1][1]=max(0,prices[1]-prices[0]);
        for(int i=2;i<range;i++){
            dp[i][0] = max(dp[i-1][0],dp[i-2][1]-prices[i]);
            dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[range-1][1];
    }
};
