/*

You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> mp = new TreeMap<>();
        for(int[] trip:trips){
            int start = mp.getOrDefault(trip[1],0)+trip[0];
            mp.put(trip[1],start);
            
            int end = mp.getOrDefault(trip[2],0)-trip[0];
            mp.put(trip[2],end);
        }
        int passengers=0;
        for(int val: mp.values()){
            passengers+=val;
            if(passengers>capacity)
                return false;   
        }
        return true;
    }
}
