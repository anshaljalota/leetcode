/*

You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int i, range = tasks.length;
        int []freq = new int[26];
        for(i=0;i<range;i++){
            freq[tasks[i]-'A']++;
        }
        Arrays.sort(freq);
        int gaps,max = freq[25]-1;
        gaps = max*n;
        for(i=24;i>=0;i--){
            gaps-=Math.min(max,freq[i]);
        }
        gaps=Math.max(0,gaps);
        return gaps+range;
    }
}
