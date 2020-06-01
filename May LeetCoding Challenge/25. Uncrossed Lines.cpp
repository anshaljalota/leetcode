/*
We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.


*/
class Solution {
public:
    int maxUncrossedLines(vector<int>& A, vector<int>& B) {
        int r = A.size(), c = B.size(),i,j;
        vector<vector<int>> dp(r+1,vector<int>(c+1,0));
        for(i=1;i<=r;i++){
            for(j=1;j<=c;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[r][c];
    }
};
