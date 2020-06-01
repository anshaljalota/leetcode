/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*/
class Solution {
public:
    int color [100000];
    int flag=0;
    unordered_map<int,vector<int>> um;
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int range = prerequisites.size();
        for(int i=0;i<numCourses;i++)
            color[i]=0;
        for(int i=0;i<range;i++){
            um[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }
        for(int i=0;i<numCourses;i++){
            if(color[i]==0)
                dfs(i);
        }
        if(flag==-1)
            return false;
        return true;
    }
    void dfs(int num){
        color[num]=1;
        for(int j=0;j<um[num].size();j++){
            if(color[um[num][j]]==1){
                flag=-1;

            }
            if(color[um[num][j]]==0)
                dfs(um[num][j]);
        }
        color[num]=2;
        
    }
};
