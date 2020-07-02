/*
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?
*/
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int range= citations.size();
        if(range==0)
            return 0;
        if(range==1){
            if(citations[0]>0)
                return 1;
            return 0;
        }
        int l=0,r=range-1,mid,val;
        while(l<=r){
            mid = (l+r)/2;
            val = range-mid;
            if(val==citations[mid]){
                return val;
            }
            else if(citations[mid]>val){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return range-l;
    }
};
