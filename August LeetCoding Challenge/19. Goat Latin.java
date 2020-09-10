/*

A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 
*/

class Solution {
    public String toGoatLatin(String S) {
        S+=" ";
        List<String> li = new ArrayList<>();
        int i,range = S.length(),idx=0;
        if(range==1)
            return "";
        String res="",temp="";
        char ch;
        for(i=0;i<range;i++){
            ch=S.charAt(i);
            if(ch==' '){
                li.add(temp);
                temp="";
            }
            else{
                temp+=ch;
            }
        }
        boolean flag;
        for(String str : li){
            temp="";
            idx++;
            flag = false;
            ch = str.charAt(0);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
               temp+=ch;
                flag=true;
            }
            for(i=1;i<str.length();i++){
                temp+=str.charAt(i);
            }
            if(!flag){
                temp+=ch;
            }
            temp+="ma";
            for(i=0;i<idx;i++)
                temp+="a";
            res+=temp;
            if(idx<li.size()){
                res+=" ";
            }
        }
        return res;
    }
}
