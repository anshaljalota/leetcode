/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
*/

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int range = nums.size();
        if(range==0)
            return 0;
        int curr=nums[0],best=nums[0];
        for(int i=1;i<range;i++){
            if(curr+ nums[i]>nums[i]){
                curr = curr+nums[i];
            }
            else{
                curr = nums[i];
            }
            if(curr>best)
                best = curr;
        }
        return best;
    }
};
