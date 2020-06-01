/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
*/

class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int len1 = J.length(),len2 = S.length(),res=0;
        unordered_map<char,int> mp;
        for(int i=0;i<len1;i++){
            mp[J[i]]++;
        }
        for(int i=0;i<len2;i++){
            if(mp.find(S[i])!=mp.end()){
                res++;
            }
        }
        return res;
    }
};
