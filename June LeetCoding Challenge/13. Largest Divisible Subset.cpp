/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.
*/
class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int i,j,range = nums.size(),max_len=0,pos;
        if(range<2)
            return nums;
        sort(nums.begin(),nums.end());
        vector<int> dpTable(range,1),parent(range,-1);
        for(i=1;i<range;i++){
            for(j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    dpTable[i]=max(dpTable[i],1+dpTable[j]);
                }
                if(dpTable[i]==1+dpTable[j])
                    parent[i]=j;
            }
            if(dpTable[i]>max_len){
                max_len=dpTable[i];
                pos=i;
            }
        }
        vector<int> result;
        while(max_len--){
            result.push_back(nums[pos]);
            pos = parent[pos];
        }
        reverse(result.begin(),result.end());
        return result;
    }
};
