/*

Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.

Follow up: Could you do this in O(n) runtime?
*/

class Solution {
    public int findMaximumXOR(int[] nums) {
        int i,j,res = 0,range = nums.length;
        for(i=0;i<range;i++) {
            for( j=i+1;j<range;j++) {
                res = Math.max(res,nums[i]^nums[j]);
            }   
        }
        return res;
    }
}
