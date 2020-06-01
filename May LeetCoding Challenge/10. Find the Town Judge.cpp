/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
*/

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        int range = trust.size();
        if(range==0){
            if(N==1)
                return 1;
            return -1;
        }
        map<int,vector<int>> mp;
        for(int i=0;i<range;i++){
            mp[trust[i][0]].push_back(trust[i][1]);
        }
        map<int,vector<int>>:: iterator it;
        int val=-1;
        for(int i=1;i<=N;i++){
            if(mp[i].size()==0){
                val = i;
                break;
            }
        }

        if(val==-1)
            return val;
        bool flag;
        for(int i=1;i<=N;i++){
            if(i==val)
                continue;
            flag = false;
            for(int j=0;j<mp[i].size();j++){
                if(mp[i][j]==val){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                return -1;
        }
        return val;
    }
};
