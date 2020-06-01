/*
Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.
*/

class Solution {
public:
    int findComplement(int num) {
       long long int res=0,rem=1;
        do{
            if(num%2==0)
                res+=rem;
            num>>=1;
            rem*=2;
        }while(num);
        return res;
    }
};
