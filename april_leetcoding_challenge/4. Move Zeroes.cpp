/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int i=0,itr=0,range = nums.size();
        for(i=0;i<range;i++){
            if(nums[i]!=0){
                swap(nums[itr++],nums[i]);
            }
        }
        
    }
};
