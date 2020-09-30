/*

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0,i,idx,range = gas.length;
        if(range==0)
            return -1;
        int [] diff = new int[range];
        List<Integer> li = new ArrayList<>();
        for(i=0;i<range;i++){
            diff[i] = gas[i]-cost[i];
            if(diff[i]>=0){
                li.add(i);
            }
            sum+=diff[i];
        }
        if(sum<0)
            return -1;
        int temp;
        for(int val: li){
            idx = range;
            sum=0;
            temp=val;
            while(idx-->0){
                sum += diff[temp];
                temp = (temp+1)%range;
                if(sum<0)
                    break;
            }
            if(sum>=0)
                return val;
    
        }
        return -1;
    }
}
