/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
*/

class Solution {
public:
    string removeKdigits(string num, int k) {
        string res="";
        int len = num.length(),i;
        if(len==k)
            return "0";
        stack<char> st;
        for( i=0;i<len;i++){
            while(k>0 && !st.empty() && num[i]<st.top()){
                st.pop();
                k--;
            }
            st.push(num[i]);
        }
        while(k--){
            st.pop();
        }
        while(!st.empty()){
            res+=st.top();
            st.pop();
        }
        for( i = res.length()-1;i>=0;i--){
            if(res[i]!='0')
                break;
        }
        res.erase(i+1);
        reverse(res.begin(),res.end());
        if(res.length()==0)
            return "0";
        return res;
    }
};
