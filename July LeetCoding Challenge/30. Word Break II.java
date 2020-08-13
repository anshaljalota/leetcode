/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
*/
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() > 100) return new ArrayList();
        List<String> res = new ArrayList<>();
        util(s,wordDict,res,new StringBuilder());
        return res;
    }
   void util(String s, List<String>wordDict, List<String> res, StringBuilder sublist){
        if(sublist.length()!=0){
            sublist.append(" ");
        }
        for(String word: wordDict){
            if(s.startsWith(word)){
                StringBuilder sb = new StringBuilder(sublist);
                sb.append(word);
                if(s.equals(word)){
                    res.add(new String(sb));
                }
                else{
                    util(s.substring(word.length()),wordDict,res,sb);
                }
            }
        }
    }
}
