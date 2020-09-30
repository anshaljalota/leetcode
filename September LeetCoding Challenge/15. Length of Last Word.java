/*

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.
*/

class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()==0)
            return 0;
        String [] arr = s.split(" ");
        int range = arr.length;
        if(range>0)
            return arr[range-1].length();
        return 0;
    }
}
