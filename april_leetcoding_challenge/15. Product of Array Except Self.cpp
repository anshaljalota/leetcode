/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/

class Solution {
public:
    
    vector<int> productExceptSelf(vector<int>& nums) {
        int range = nums.size();
        vector<int> res;
        if(range==0)
            return res;
        int left[range];
        int right[range];
        left[0]=1;
        right[range-1]=1;
        for(int i=1;i<range;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        for(int i=range-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<range;i++)
            res.push_back(left[i]*right[i]);
        return res;
        
    }
};
