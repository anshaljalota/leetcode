/*

Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.
*/

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if(N==1){
            return new int[]{0,1,2,3,4,5,6,7,8,9};   
        }
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<10;i++){
            dfs(N-1,i,K,result);
        }
        int [] res = new int[result.size()];
        int idx=0;
        for(int val: result){
            res[idx++]=val;
        }
        return res;
    }
    void dfs(int N, int num, int K, List<Integer> result){
        if(N==0){
            result.add(num);
            return;
        }
        if(num%10 + K<10){
            dfs(N-1,num*10+num%10+K,K,result);
        }
        if(K!=0 && num%10-K>=0){
            dfs(N-1,num*10+num%10-K,K,result);
        }
    }
}
