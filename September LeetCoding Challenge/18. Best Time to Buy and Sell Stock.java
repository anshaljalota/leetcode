/*

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int i,range = prices.length,res=0;
        if(range==0)
            return res;
        int buy=prices[0];
        
        for(i=1;i<range;i++){
            if(prices[i]>buy){
                res = Math.max(res,prices[i]-buy);
            }
            else{
                buy = prices[i];
            }
        }
        
        return res;
    }
}
