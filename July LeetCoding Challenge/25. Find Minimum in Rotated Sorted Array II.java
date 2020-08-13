/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.
*/
class Solution {
    public int findMin(int[] nums) {
        int low=0,high = nums.length-1,mid;
        while(low<=high){
            mid = low + (high - low)/2;
            if(nums[mid]<nums[high]){
                high = mid;
            }
            else if(nums[mid]>nums[high]){
                low = mid+1;
            }
            else high--;
        }
        return nums[low];
    }
}
