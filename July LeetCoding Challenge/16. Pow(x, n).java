/*

Implement pow(x, n), which calculates x raised to the power n (xn).
*/

class Solution {
    public double myPow(double x, int n) {
        double res=1;
        if(n==0)
            return res;
        boolean flag = false;
        if(n<0)
            flag = true;
        long m = n;
        if(flag)
            m*=-1;
        while(m>0){
            if(m%2!=0)
                res = res *x;
            x*=x;
            m>>=1;
        }
        if(flag)
            return 1.0/res;
        return res;
    }
}
