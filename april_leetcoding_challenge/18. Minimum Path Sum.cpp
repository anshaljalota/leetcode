/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int row = grid.size();
        if(row==0)
            return 0;
        int col = grid[0].size();
        if(col==0)
            return 0;
        vector<vector<int>> dp (row,vector<int>(col,0));
        dp[0][0]= grid[0][0];
        for(int i=1;i<col;i++){
            dp[0][i]= grid[0][i] + dp[0][i-1];
        }
        for(int i=1;i<row;i++){
            dp[i][0]= grid[i][0] + dp[i-1][0];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j]= grid[i][j] + min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }
    
};
