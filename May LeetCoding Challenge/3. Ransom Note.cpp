/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.
*/
class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int mag_len =magazine.length(),note_len = ransomNote.length();
        if(mag_len<note_len)
            return false;
        unordered_map<char,int> mp;
        for(int i=0;i<mag_len;i++){
            mp[magazine[i]]++;
        }
        for(int i=0;i<note_len;i++){
            if(mp.find(ransomNote[i])==mp.end() || mp[ransomNote[i]]<=0){
                return false;
            }
            else{
                mp[ransomNote[i]]--;
            }
        }
        return true;
    }
};
