/*

In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.

You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
*/

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int range = timeSeries.length;
        if(range==0)
            return 0;
        int i,curr_val=0;
        for(i=0;i<range-1;i++){
            curr_val+=Math.min(timeSeries[i+1]-timeSeries[i],duration);
        }
        return curr_val+duration;
    }
}
