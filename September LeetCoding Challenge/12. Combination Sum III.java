/*

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
*/

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<List<Integer>>();
        
        util(k,n,1,new ArrayList<>());
        
        return res;
    }
    
    void util(int k, int n, int start, List<Integer> temp){
        if(k==0&&n==0){
            res.add(new ArrayList<>(temp));
            return ;
        }
        if(n<0)
            return ;
        for(int i=start;i<10;i++){
            temp.add(i);
            util(k-1,n-i,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
