/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
*/

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        int range = nums.size();
        if(range==0)
            return 0;
        int sum=0,max_len=0;
        unordered_map<int,int>mp;
        mp[0]=-1;
        for(int i=0;i<range;i++){
            sum += (nums[i]==0)?-1:1;
            if(mp.find(sum)!=mp.end()){
                max_len = max(max_len,i-mp[sum]);
            }
            else{
                mp[sum]=i;
            }
        }
        return max_len;
    }
};
