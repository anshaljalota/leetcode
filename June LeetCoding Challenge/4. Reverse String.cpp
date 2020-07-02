/*

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
*/
class Solution {
public:
    void reverseString(vector<char>& s) {
        int range =s.size();
        char ch;
        for(int i=0;i<range/2;i++){
            ch=s[i];
            s[i]=s[range-1-i];
            s[range-1-i]=ch;
        }
        
    }
};
