/*
Given a string, sort it in decreasing order based on the frequency of characters.
*/

class Solution {
public:
    string frequencySort(string s) {
        int i,len = s.length();
        string res="";
        if(len ==0)
            return res;
        map<char,int> mp;
        for(i=0;i<len;i++)
            mp[s[i]]++;
        priority_queue<pair<int,char>> pq;
        for(auto it = mp.begin();it!=mp.end();it++){
            pq.push(make_pair(it->second,it->first));
        }
        int count;
        while(!pq.empty()){
            count = pq.top().first;
            while(count--)
                res+=pq.top().second;
            pq.pop();
        }
        return res;
    }
};
