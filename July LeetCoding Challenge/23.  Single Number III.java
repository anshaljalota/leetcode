/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
*/
class Solution {
    public int[] singleNumber(int[] nums) {
        int [] res = new int [2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int i=0;
        for(Map.Entry<Integer,Integer> e : hm.entrySet()){
            if(e.getValue()==1)
                res[i++]=e.getKey();
        }
        return res;
    }
}
