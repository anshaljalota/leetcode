/*

Given an input string, reverse the string word by word.
*/
class Solution {
    public String reverseWords(String s) {
        s+=' ';
        Stack<String> st = new Stack<>();
        String res="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ' && res.length()>0){
                st.push(res);
                res="";
            }
            else if(s.charAt(i)!=' '){
                res+=s.charAt(i);
            }
        }
        while(!st.isEmpty()){
            res+=st.pop();
            if(st.size()>0)
                res+=" ";
        }
        return res;
    }
}
