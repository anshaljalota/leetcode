/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.
*/
class Solution {
    public String addBinary(String a, String b) {
        int carry=0;
        int i=a.length()-1,j=b.length()-1,a_val,b_val;
        String res="",rev="";
        while(i>=0 || j>=0){
            a_val=0;
            b_val=0;
            if(i>=0)
                a_val = a.charAt(i)-'0';
            if(j>=0)
                b_val = (int)b.charAt(j)-'0';
            int temp = a_val + b_val + carry;
            carry = temp /2;
            temp%=2;
            rev=temp+rev;
            i--;
            j--;
        }
        if(carry>0)
            rev = 1+rev;
        return rev;
    }
}
