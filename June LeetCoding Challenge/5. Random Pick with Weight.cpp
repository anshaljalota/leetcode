/*

Given an array w of positive integers, where w[i] describes the weight of index i(0-indexed), write a function pickIndex which randomly picks an index in proportion to its weight.

For example, given an input list of values w = [2, 8], when we pick up a number out of it, the chance is that 8 times out of 10 we should pick the number 1 as the answer since it's the second element of the array (w[1] = 8).
*/

class Solution {
public:
    vector<int> vec;
    int sum;
    Solution(vector<int>& w) {
        sum=0;
        for(int i=0;i<w.size();i++){
            sum+=w[i];
            vec.push_back(sum);
        }
    }
    
    int pickIndex() {
        int idx = rand()%sum;
        return binSearch(idx+1);
    }
    int binSearch(int val){
        int l=0,r=vec.size()-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(vec[mid]<val)
                l=mid+1;
            else
                r=mid;
        }
        return l;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(w);
 * int param_1 = obj->pickIndex();
 */
