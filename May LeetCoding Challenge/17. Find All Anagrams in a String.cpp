/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
*/

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> res,mp(26,0),ms(26,0);
        int len1 = s.length();
        int len2 = p.length();
        if(len1==0 ||len2>len1)
            return res;
        
        for(int i=0;i<len2;i++)
            mp[p[i]-'a']++;
        for(int i=0;i<len2;i++){
            ms[s[i]-'a']++;
        }
        if(mp==ms)
            res.push_back(0);
        for(int i=len2;i<len1;i++){
            ms[s[i-len2]-'a']--;
            ms[s[i]-'a']++;
            if(ms==mp)
                res.push_back(i-len2+1);
        }
        return res;
    }
};
