/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4
*/
class Solution {
    public boolean isPowerOfFour(int num) {
        int freq=0;
        int x = num&(num-1);
        if(num>0 &&x==0){
            while(num>1){
                num>>=1;
                freq++;
            }
            if(freq%2==0)
                return true;
            return false;
        }
        return false;
    }
}
