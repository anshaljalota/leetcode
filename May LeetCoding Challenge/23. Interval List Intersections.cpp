/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
*/

class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& A, vector<vector<int>>& B) {
        vector<vector<int>> res;
        int a_len=A.size(),b_len = B.size();
        if(a_len==0 && b_len==0)
            return res;
        if(a_len==0)
            return res;
        if(b_len==0)
            return res;
        int i=0,j=0,l1,l2,r1,r2;
        vector<int> vec;
        while(i<a_len || j<b_len){
            vec.clear();
            if(i<a_len){
                l1 = A[i][0];
                r1 = A[i][1];
            }
            else{
                return res;
            }
            if(j<b_len){
                l2 = B[j][0];
                r2 = B[j][1];
            }
            else{
                return res;
            }
            vec.push_back(max(A[i][0],B[j][0]));
            vec.push_back(min(A[i][1],B[j][1]));
            if(vec[0]<=vec[1])
            res.push_back(vec);
            if(r1<r2){
                i++;
            }
            
            else{
               j++; 
            }
        }
        return res;
        
    }
};
