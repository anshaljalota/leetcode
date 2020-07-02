/*
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
*/
class Solution {
public:
    int change(int amount, vector<int>& coins) {
      int range = coins.size();
        if(range ==0 && amount==0)
            return 1;
        if(range==0)
            return 0;
        int i,j;
        vector<int> ways(amount+1,0);
        ways[0]=1;
        for(i=0;i<range;i++){
            for(j=0;j<=amount;j++){
                if(j>=coins[i]){
                    ways[j] = ways[j-coins[i]] + ways[j];
                }
            }
        }
        return ways[amount];
    }
};
