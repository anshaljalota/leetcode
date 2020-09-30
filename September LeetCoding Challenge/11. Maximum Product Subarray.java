/*

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
*/

class Solution {
    public int maxProduct(int[] nums) {
        int range = nums.length;
        if(range==0)
            return 0;
        int curr_max,curr_min;
        int res = nums[0];
        int prev_max=res,prev_min=res;
        for(int i=1;i<range;i++){
            curr_max = Math.max(prev_max*nums[i],Math.max(prev_min*nums[i],nums[i]));
            curr_min = Math.min(prev_max*nums[i],Math.min(prev_min*nums[i],nums[i]));
            res = Math.max(res,Math.max(curr_max,curr_min));
            prev_max = curr_max;
            prev_min=curr_min;
        }
        return res;
    }
}
