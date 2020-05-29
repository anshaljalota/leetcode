/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
*/

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int range = nums.size();
        if(range<2)
            return true;
        int i,max=-1;
        for(i=0;i<range-1;i++){
            if(nums[i]==0 && max<=i)
                return false;
            if(i+nums[i]>max){
                max = i+nums[i];
            }
        }
        if(max>=range-1)
            return true;
        return false;
    }
};
