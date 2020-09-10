/*


Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.
*/

class Solution {
    public boolean isPalindrome(String s) {
        String temp="";
        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            if((ch>='a' && ch<='z')||(ch>='0' && ch<='9') ){
                temp+=ch;
            }
            else if((ch>='A' && ch<='Z')){
                temp+= (char)(ch+32);
            }
        }
        int start=0,end=temp.length()-1;
        while(start<end){
            if(temp.charAt(start)!=temp.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
