/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
*/

class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> res;
        for(int i=0;i<=num;i++){
            res.push_back(util(i));
        }
        return res;
    }
    int util(int x){
        if(x==0)
            return 0;
        if(x==1||x==2)
            return 1;
        int count=0;
        while(x){
            x= x&(x-1);
            count++;
        }
        return count;
    }
};
