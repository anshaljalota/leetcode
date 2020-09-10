/*

You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
*/

class Solution {
    int bs(int []arr, int val){
        int beg =0,end=arr.length-1;
        int ans=-1;
        while(beg<=end){
            int mid = beg+(end-beg)/2;
            if(arr[mid]>=val){
                end=mid-1;
                ans = mid;
            }
            else{
                beg=mid+1;
            }
        }
        return ans; 
    }
    public int[] findRightInterval(int[][] intervals) {
        int range = intervals.length;
        int [] res = new int[range];
        int []temp = new int[range];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<range;i++){
             temp[i] = intervals[i][0];
            hm.put(temp[i],i); 
        }
        Arrays.sort(temp);
        for(int i=0;i<range;i++){
            int idx = bs(temp,intervals[i][1]);
            res[i]= idx==-1?-1:hm.get(temp[idx]);
        }
        return res;
    }
}
