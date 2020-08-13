/*

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.
*/
class Solution {
    public int arrangeCoins(int n) {
        long  l=0,u=n,mid,val;
        while(l<=u){
            mid = l + (u-l)/2;
            val = mid*(mid+1)/2;
            if(val==n){
                return (int)mid;
            }
            else if(val>n){
                u=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return (int)u;
    }
}
