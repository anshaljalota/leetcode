/*

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] temp = str.split(" ");
        if(temp.length!=pattern.length())
            return false;
        HashMap<Character,String> hm_word = new HashMap<>();
        HashMap<String,Character> hm_char = new HashMap<>();
        for(int i=0;i<temp.length;i++){
            String val = temp[i];
            char ch = pattern.charAt(i);
            if(!hm_word.containsKey(ch)){
                if(hm_char.containsKey(val)){
                    return false;
                }
                else{
                    hm_word.put(ch,val);
                    hm_char.put(val,ch);
                }
            }
            else{
                String w = hm_word.get(ch);
                if(!w.equals(val))
                    return false;
            }
        }
        return true;
    }
}
