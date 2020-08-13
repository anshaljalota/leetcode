/*

Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
*/
class Solution {
    public double angleClock(int hour, int minutes) {
        double h,m;
        h = (hour%12)*30 + minutes*0.5;
        m = minutes*6;
        double res = Math.abs(h-m);
        return Math.min(res,360-res);
    }
}
