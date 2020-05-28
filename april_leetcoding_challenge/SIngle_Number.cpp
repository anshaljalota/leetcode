/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
*/
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int res;
        for(int i=0;i<nums.size();i++){
            res = res^nums[i];
        }
        return res;
    }
};
