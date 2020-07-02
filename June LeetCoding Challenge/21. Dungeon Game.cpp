/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned
*/
class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int row = dungeon.size();
        if(row==0)
            return 0;
        int col = dungeon[0].size();
        if(col==0)
            return 0;
        int i,j;
        vector<vector<int>>dp(row,vector<int>(col,0));
        
        for(i=row-1;i>=0;i--){
            for(j=col-1;j>=0;j--){
                if(i==row-1 && j==col-1){
                    dp[i][j]= min(0,dungeon[i][j]);
                }
                else if(i==row-1){
                    dp[i][j] = min(0,dungeon[i][j]+dp[i][j+1]);
                }
                else if(j==col-1){
                    dp[i][j]=min(0,dungeon[i][j]+dp[i+1][j]);
                }
                else{
                    dp[i][j]=min(0,dungeon[i][j]+max(dp[i][j+1],dp[i+1][j]));
                }
            }
        }
        return 1-dp[0][0];
    }
};
