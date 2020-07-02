/*
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
Note:

1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000
*/
class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        int i,sum=0,range=costs.size(),c1=0,c2=0;
        vector<pair<int,int>> vec;
        for(int i=0;i<range;i++){
            vec.push_back(make_pair(costs[i][0]-costs[i][1],i));
        }
        sort(vec.begin(),vec.end());
        for(int i=range-1;i>=0;i--){
            if(c2<range/2){
                sum+=costs[vec[i].second][1];
                c2++;
            }
            else{
                sum+=costs[vec[i].second][0];
            }
        }
        return sum;
    }
};
