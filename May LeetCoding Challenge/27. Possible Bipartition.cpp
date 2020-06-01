/*
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.
*/

class Solution {
public:
    bool possibleBipartition(int N, vector<vector<int>>& dislikes) {
        int range = dislikes.size(),i,j;
        vector<int> color(N+1,0);
        vector<bool> visit(N+1,false);
        vector<vector<int>>adj(N+1);
        for(i=0;i<range;i++){
            adj[dislikes[i][0]].push_back(dislikes[i][1]);
            adj[dislikes[i][1]].push_back(dislikes[i][0]);
        }
        queue<int> q;
        for(i=1;i<=N;i++){
            if(!visit[i]){
                color[i]=1;
                q.push(i);
                while(!q.empty()){
                    int f = q.front();
                    q.pop();
                    if(!visit[f]){
                        visit[f]=true;

                        for(auto v:adj[f]){
                            if(color[v]==color[f])
                                return false;
                            if(color[f]==1)
                                color[v]=2;
                            else
                                color[v]=1;
                            q.push(v);
                        }
                    }
                }
            }
        }
        return true;
    }
};
