/*


Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int temp;
        for(int i=0;i<nums.length;i++){
            temp = nums[i];
            if(temp<0){
                temp*=-1;
            }
            if(nums[temp-1]<0)
                res.add(temp);
            nums[temp-1]*=-1; 
        }
        return res;
    }
}
