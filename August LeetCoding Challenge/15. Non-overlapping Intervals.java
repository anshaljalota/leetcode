/*

Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int range = intervals.length;
        if(range==0)
            return 0;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int res=0,i;
        int  end = intervals[0][1];
        for(i=1;i<range;i++){
            if(intervals[i][0]<end){
                end = Math.min(end,intervals[i][1]);
                res++;
            }
            else{
                end = intervals[i][1];
            }
        }
        return res;
    }
}
