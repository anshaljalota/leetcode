/*

Given an unsorted integer array, find the smallest missing positive integer.
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i,temp,range = nums.length;
        for( i=0;i<range;i++){
            while(nums[i]>0 && nums[i]<=range && nums[nums[i]-1]!=nums[i]){
                temp = nums[nums[i]-1];;
                nums[nums[i]-1]=nums[i]; 
                nums[i] = temp;
            }
        }
        for(i=0;i<range;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return range+1;
    }
}
