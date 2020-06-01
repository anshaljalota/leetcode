/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int range = nums.size();
        unordered_map<int,int>um;
        for(int i=0;i<range;i++){
            um[nums[i]]++;
            if(um[nums[i]]>range/2)
                return nums[i];
        }
        return -1;
    }
};
