/*
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Constraints:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.
*/
class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int K) {
        vector<vector<int>> dp(K+2,vector<int> (n,INT_MAX));
        int i,j,s,d,c;
        for(i=0;i<K+2;i++){
            dp[i][src]=0;
        }
        for(i=1;i<K+2;i++){
            for( j=0;j<flights.size();j++){
                s = flights[j][0];
                d = flights[j][1];
                c = flights[j][2];
                if(dp[i-1][s]!=INT_MAX){
                    dp[i][d] = min(dp[i][d],dp[i-1][s]+c);
                }
            }
        }
        if(dp[K+1][dst]==INT_MAX)
            return -1;
        return dp[K+1][dst];
    }
};
