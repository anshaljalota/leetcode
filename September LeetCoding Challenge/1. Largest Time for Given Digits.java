/*

Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.

24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.

Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string.
*/
class Solution {
    int max_time=-1;
    public String largestTimeFromDigits(int[] A) {
        max_time=-1;
        permute(A,0);
        if(max_time==-1)
            return "";
        return String.format("%02d:%02d", max_time / 60, max_time % 60);
    }
    void permute(int[] A, int start){
        if(start==A.length){
            checkTime(A);
            return;
        }
        for(int i=start;i<A.length;i++){
            swap(A,i,start);
            permute(A,start+1);
            swap(A,i,start);
        }
    }
    
    void swap(int[] A, int l, int r){
        if(l!=r){
            int temp=A[l];
            A[l]=A[r];
            A[r]=temp;
        }
    }
    
    void checkTime(int []A){
       int h=0,m=0;
        h=A[0]*10 + A[1];
        m=A[2]*10 + A[3];
        if(h<24 && m<60){
            max_time = Math.max(max_time,h*60+m);
        }
    }
}
