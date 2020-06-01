/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
*/

class Solution {
public:
    int calc_distance(int x, int y){
        return x*x + y*y;
    }
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
        int range = points.size();
        if(range==K)
            return points;
        vector<vector<int>> res;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
        int dist;
        for(int i=0;i<range;i++){
            dist = calc_distance(points[i][0],points[i][1]);
            pq.push(make_pair(dist,i));
        }
        while(K--){
            res.push_back(points[pq.top().second]);
            pq.pop();
        }
        return res;
    }
};
