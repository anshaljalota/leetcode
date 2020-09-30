/*

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and 
the absolute difference between i and j is at most k.
*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer l = tree.floor(nums[i]);
            Integer r = tree.ceiling(nums[i]);
            if((l!=null && (long)nums[i]-l<=t)||(r!=null && (long)r - nums[i]<=t)){
                return true;
            }
            tree.add(nums[i]);
            if(i>=k)
                tree.remove(nums[i-k]);
        }
        return false;
    }
}
