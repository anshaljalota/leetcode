/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        int count=0,range=word.length();
        char ch;
        for(int i=0;i<range;i++){
            ch=word.charAt(i);
            if(ch>='A' && ch<='Z')
                count++;
        }
        if(count==range||count==0)
            return true;
        if(count==1){
            ch = word.charAt(0);
            if(ch>='A' && ch<='Z')
                return true;
        }
        return false;
    }
}
