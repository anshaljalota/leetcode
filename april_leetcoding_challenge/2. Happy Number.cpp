/*
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.
*/
class Solution {
public:
    bool isHappy(int n) {
        int temp=n,sum=0,rem=0;
        unordered_map<int,bool>m;
        do{
            sum=0;
            while(temp>0){
                rem= temp%10;
                sum = sum + rem*rem;
                temp/=10;
            }
            temp=sum;
            if(sum==1)
                return true;
            if(m[sum]){
                return false;
            }
            else
                m[sum]=true;
        }while(temp!=n);
        return false;
    }
};
