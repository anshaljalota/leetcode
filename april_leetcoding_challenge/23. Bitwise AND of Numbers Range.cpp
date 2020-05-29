/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
*/
class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        long long int res=0;
        for(int i=31;i>=0;i--){
            int a = (m>>i)%2;
            int b = (n>>i)%2;
            if(a==b)
                res+= (a<<i);
            else
                break;
            
        }
        return res;
    }
};
