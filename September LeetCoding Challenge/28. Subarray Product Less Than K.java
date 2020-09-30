/*

Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res=0;
        if(k==0)
            return res;
        int range = nums.length;
        if(range==0)
            return res;
        int prod=1;
          for (int i = 0, j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i++];
            }
            res += j - i + 1;
        }
        return res;
    }
}
