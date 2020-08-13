/*

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int i,j,range = nums.length;
        if(range==0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int subset_size = (int)Math.pow(2,range);
        for(i=0;i<subset_size;i++){
            List<Integer> li = new ArrayList<>();
            for(j=0;j<range;j++){
                if(((i>>j)&1)==1){
                    li.add(nums[j]);
                }
            }
            res.add(li);
        }
        return res;
    }
}
