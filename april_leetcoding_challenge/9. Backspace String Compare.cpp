/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.
*/

class Solution {
public:
    string util(string S){
        bool prev=false;
        int freq=0;
        string res="";
        stack<char> st;
        for(int i=0;i<S.length();i++){
            if(S[i]=='#'){
                if(st.empty()){
                    prev=true;
                    freq++;
                }
                else{
                    st.pop();
                    freq--;
                }
            }
            else {
                prev=false;
                st.push(S[i]);
            }
        }
        while(!st.empty()){
            res+= st.top();
            st.pop();
        }
        return res;
    }
    bool backspaceCompare(string S, string T) {
        //base case
        if(S==T)
            return true;
        string str1="",str2="";
        str1 = util(S);
        str2 = util(T);
        return (str1==str2);
    }
};
