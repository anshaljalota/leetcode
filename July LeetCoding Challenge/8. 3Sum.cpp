/*

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.
*/
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        int i,range=nums.size();
        if(range<3)
            return res;
        sort(nums.begin(),nums.end());
        if(nums[range-1]<0 || nums[0]>0)
            return res;
        for(i=0;i<range-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int left = i+1;
            int right = range-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum<0)
                    left++;
                if(sum>0)
                    right--;
                if(sum==0){
                    res.push_back({nums[i],nums[left],nums[right]});
                    while(left < right && nums[left]==nums[left+1])
                        left++;
                    while(left<right && nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                }
            }
        }

        return res;
    }
};
