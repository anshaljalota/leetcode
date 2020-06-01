/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
*/

class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int len1=s1.length(),len2=s2.length(),i;
        if(len2==0 || len2<len1)
            return false;
        vector<int>m1(26,0),m2(26,0);
        
        for(i=0;i<len1;i++)
            m1[s1[i]-'a']++;
        for(i=0;i<len1;i++){
            m2[s2[i]-'a']++;
        }
        if(m1==m2)
            return true;
        for(i=len1;i<len2;i++){
            m2[s2[i-len1]-'a']--;
            m2[s2[i]-'a']++;
            if(m1==m2)
                return true;
        }
        return false;
    }
};
