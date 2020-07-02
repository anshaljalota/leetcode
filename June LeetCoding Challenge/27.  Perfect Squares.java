/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
*/

class Solution {
    public int numSquares(int n) {
        int []dp = new int[n+1];
        for(int i =1;i<=n;i++){
            int min_val = i;
            int sq=1,x=1;
            while(sq<=i){
                min_val = Math.min(min_val,1+dp[i-sq]);
                x++;
                sq = x*x;
            }
            dp[i]=min_val;
        }
        return dp[n];
    }
}
