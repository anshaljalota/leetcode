/*


Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
*/

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int range=citations.length;
        if(range==0)
            return 0;
        if(range==1){
            if(citations[0]==0)
                return 0;
            return 1;
        }
        int mid=0,beg=0,end=range -1;
        
        while(beg<=end){
            mid = beg + (end-beg)/2;
            if(citations[mid]<range-mid){
                beg=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return range-beg;
    }
}
