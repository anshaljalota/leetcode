/*

Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int i,carry=1,len=digits.length,temp=0;
        int [] res = new int[len];
        for(i=len-1;i>0;i--){
            temp = digits[i]+carry;
            carry = temp/10;
            temp = temp%10;
            res[i]=temp;
        }
        res[0] = carry+digits[0];
        if(res[0]>9){
            carry = res[0]/10;
            res[0] = res[0]%10;
            int [] res1 = new int[len+1];
            for(i=len;i>0;i--){
                res1[i] = res[i-1];
            }
            res1[0] = carry;
            return res1;
        }
        return res;
    }
}
