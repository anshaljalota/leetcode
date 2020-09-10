/*

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
*/

class Solution {
    public int longestPalindrome(String s) {
        int res=0;
        int freq[] = new int[123];
        boolean flag = false;
        for(int i=0;i<s.length();i++){
            freq[(int)s.charAt(i)]++;
        }
        for(int val: freq){
            res+= val/2 *2;
            if(res%2==0 && val%2==1)
                res++;
            
        }
        return res;
    }
}
