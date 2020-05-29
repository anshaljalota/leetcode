/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
*/

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int range=nums.size();
        if(range==0)
            return -1;
        int start = 0,end=range-1;
        while(start<=end){
            int mid = (start+end)/2 , left = nums[start], right=nums[end];
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<left){
                if(target<=right && target>nums[mid])
                    start = mid+1;
                else
                    end = mid-1;
            }
            else if(nums[mid]>right){
                if(target<nums[mid] && target>=left)
                    end = mid-1;
                else
                    start = mid+1;
            }
            else{
                if(nums[mid]>target)
                    end = mid-1;
                else
                    start = mid+1;
            }
        }
        return -1;
    }
    
    
};
