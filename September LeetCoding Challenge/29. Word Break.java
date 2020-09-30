/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int range = s.length();
        boolean[] res = new boolean[range+1];
        res[0]=true;
        for(int i=1;i<=range;i++){
            for(int j=0;j<i;j++){
                if(res[j] && wordDict.contains(s.substring(j,i))){
                    res[i]=true;
                    break;
                }
            }
        }
        return res[range];
    }
}
