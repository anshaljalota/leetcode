/*
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.

*/

class Solution {
public:
    bool checkValidString(string s) {
        int range = s.length();
        if(range==0)
            return true;
        int low=0,high=0;
        char c;
        for(int i=0;i<range;i++){
            c=s[i];
            low+= c=='('?1:-1;
            high+= c!=')'?1:-1;
            if(high<0)
                break;
            low = max(0,low);
        }
        return low==0;
    }
};
