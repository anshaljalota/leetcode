/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.
*/
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int range = nums.size();
        if(range==0)
            return range;
        int l=0,r=range,mid;
        if(target<nums[0])
            return 0;
        if(target>nums[r-1])
            return range;
        if(target==nums[0])
            return 0;
        while(l<r){
            mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid-1]<target && nums[mid]>target){
                return mid;
            }
            else if (nums[mid]>target){
                r=mid;
            }
            else{
                l=mid+1;
            }

        }
        
        return mid;
    }
};
