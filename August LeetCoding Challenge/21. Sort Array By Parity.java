/*

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.
*/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int range = A.length;
        int odd_idx=range-1,even_idx=0;
        int [] res  = new int[range];
        for(int i=0;i<range;i++){
            if(A[i]%2==0){
                res[even_idx] = A[i];
                even_idx++;
            }
            else{
                res[odd_idx] = A[i];
                odd_idx--;
            }
        }
        return res;
    }
}
