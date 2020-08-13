/*
Reverse bits of a given 32 bits unsigned integer.

Note:
Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n==0)
            return 0;
        int res=0,i;
        for(i=1;i<32;i++){
            if((n&1)==1){
                res = res|1;
            }
            res = res<<1;
            n = n>>1;
        }
        if((n&1)==1)
            res = res|1;
        return res;
    }
}
