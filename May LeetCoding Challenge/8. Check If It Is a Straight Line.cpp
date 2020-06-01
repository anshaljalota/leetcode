/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
*/

class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        int range = coordinates.size();
        if(range<3)
            return true;
        sort(coordinates.begin(),coordinates.end());
        int temp,y = (coordinates[1][1] - coordinates[0][1]),x=(coordinates[1][0] - coordinates[0][0]);
        for(int i=2;i<range;i++){
            if(x*(coordinates[i][1] - coordinates[i-1][1])!=y*(coordinates[i][0] - coordinates[i-1][0]))
                return false;
            
        }
        return true;
    }
};
