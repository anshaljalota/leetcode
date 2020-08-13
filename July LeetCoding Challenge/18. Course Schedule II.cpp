/*

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
*/
class Solution {
public:
    vector<int> res;
    map<int,vector<int>>m;
    int val =0;
    int color[10000];//0->unvisited, 1->visited, 2->done with dfs
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        int i,r = prerequisites.size();
        for(i=0;i<numCourses;i++){
            color[i]=0;
        }
        for(i=0;i<r;i++){
            m[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        for(i=0;i<numCourses;i++){
            if(color[i]==0)
                topological_sort(i);
        }
        if(val==-1){
            res.clear();
            return res;
        }
            
        reverse(res.begin(),res.end());
        return res;
    }
    void topological_sort(int i){
        color[i]=1;
        for(int j : m[i]){
            if(color[j]==1)
                val=-1;
            if(color[j]==0)
                topological_sort(j);
        }
        color[i]=2;
        res.push_back(i);
    }
};
