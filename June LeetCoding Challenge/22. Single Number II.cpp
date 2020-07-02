/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int i, range = nums.size();
        unordered_map<int,int> um;
        for(i=0;i<range;i++){
            um[nums[i]]++;
        }
        unordered_map<int,int> :: iterator itr;
        for(itr=um.begin();itr!=um.end();itr++){
            if(itr->second==1)
                return itr->first;
        }
        return -1;
    }
};
