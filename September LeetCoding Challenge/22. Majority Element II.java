/*

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int range = nums.length;
        if(range==0)
            return new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        int count = range/3;
        for(int val:nums){
            int freq = mp.getOrDefault(val,0);
            mp.put(val,freq+1);
        }
        for(Map.Entry<Integer,Integer> e: mp.entrySet()){
            if(e.getValue()>count){
                li.add(e.getKey());
            }
        }
        return li;
    }
}
