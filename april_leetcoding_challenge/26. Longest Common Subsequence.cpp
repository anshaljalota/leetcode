/*
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.
*/
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int r = text1.length();
        int c = text2.length();
        int i,j;
        int dp[r+1][c+1];
        for(i=0;i<r+1;i++)
            for(j=0;j<c+1;j++)
                dp[i][j]=0;
        for(i=1;i<r+1;i++){
            for(j=1;j<c+1;j++){
                if(text1[i-1]==text2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j]= max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[r][c];
    }
};
