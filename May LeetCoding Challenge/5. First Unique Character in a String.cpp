/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
*/

class Solution {
public:
    int firstUniqChar(string s) {
        int len = s.length();
        if(len==0)
            return -1;
        unordered_map<char,int>um;
        for(int i=0;i<len;i++)
            um[s[i]]++;
        for(int i=0;i<len;i++){
            if(um[s[i]]==1)
                return i;
        }
        return -1;
    }
};
