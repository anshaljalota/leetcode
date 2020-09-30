/*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

class Solution {
    public int rob(int[] nums) {
        int range = nums.length;
        if(range==0)
            return 0;
        if(range==1)
            return nums[0];
        if(range==2)
            return Math.max(nums[0],nums[1]);
        int i=2,a,b,c=0;
        a = Math.max(nums[0],nums[1]);
        b = nums[0];
        while(i<range){
            c = Math.max(a,b+nums[i]);
            b=a;
            a=c;
            i++;
        }
        return c;
    }
}
