/*

Given a column title as appear in an Excel sheet, return its corresponding column number.
*/

class Solution {
    public int titleToNumber(String s) {
        int range = s.length();
        int res=0,temp=0;
        for(int i=0;i<range;i++){
            temp = temp*26 +  s.charAt(i)-'A' + 1;
        }
        res=temp;
        return res;
    }
}
