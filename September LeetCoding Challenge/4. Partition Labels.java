/*

A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        
        int []loc = new int[26];
        int range = S.length(),i,j=0,anc=0;
        for(i=0;i<range;i++){
            loc[S.charAt(i)-'a']=i;
        }
        for(i=0;i<range;i++){
            j = Math.max(j,loc[S.charAt(i)-'a']);
            if(i==j){
                res.add(j-anc+1);
                anc=i+1;
            }
        }
        return res;
    }
}
