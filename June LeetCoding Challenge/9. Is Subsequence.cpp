/*
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
*/
class Solution {
public:
    bool isSubsequence(string s, string t) {
        int l1=s.length(),l2=t.length(),i,j;
        vector<vector<int>> vec (l1+1,vector<int>(l2+1,0));
        for(i=1;i<=l1;i++){
            for(j=1;j<=l2;j++){
                if(s[i-1]==t[j-1]){
                    vec[i][j]=vec[i-1][j-1]+1;
                    if(vec[i][j]==l1)
                        return true;
                }
                else{
                    vec[i][j]=max(vec[i-1][j],vec[i][j-1]);
                }
            }
        }
        return vec[l1][l2]==l1;
    }
};
