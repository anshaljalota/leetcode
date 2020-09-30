/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> li = new ArrayList<>();
        for(int[] arr : intervals){
            if(arr[1]<newInterval[0]){
                li.add(arr);
            }
            else if(newInterval[1]<arr[0]){
                li.add(newInterval);
                newInterval = arr;
            }
            else{
                newInterval[0]=Math.min(newInterval[0],arr[0]);
                newInterval[1]=Math.max(newInterval[1],arr[1]);
            }
        }
        li.add(newInterval);
        return li.toArray(new int[li.size()][]);
    }
}
