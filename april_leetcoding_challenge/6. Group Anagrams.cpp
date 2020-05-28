/*
Given an array of strings, group anagrams together.

Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        int range = strs.size();
        if(range==0)
            return res;
        map<string,vector<string>> m;
        string temp;
        for(int i=0;i<range;i++){
            temp = strs[i];
            sort(strs[i].begin(),strs[i].end());
            m[strs[i]].push_back(temp);
        }
        map<string,vector<string>>:: iterator itr;
        for(itr = m.begin();itr!=m.end();itr++){
            res.push_back(itr->second);
        }
        return res;
    }
};

