/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int range = nums.size();
        if(range==1 && nums[0]==k)
            return 1;
        int res=0;
        vector<int> sum (range+1,0);
        sum[0]=0;
        for(int i = 1;i<=range;i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        for(int i=0;i<range;i++){
            for(int j=i+1;j<=range;j++){
                if(sum[j]-sum[i]==k )
                    res++;
            }
        }
        return res;
    }
};
