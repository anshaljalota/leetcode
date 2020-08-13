/*

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 2^31
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int count=0,res=x^y;
        while(res!=0){
            res = res &(res-1);
            count++;
        }
        return count;
    }
}
