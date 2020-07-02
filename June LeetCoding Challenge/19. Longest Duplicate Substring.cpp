/*
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)
Note:

2 <= S.length <= 10^5
S consists of lowercase English letters.
*/
class Solution {
public:
    int prime = 10000007;
    vector<int> pow;
    string longestDupSubstring(string S) {
        int range = S.length();
        int i,l = 0, r = range-1,mid;
        pow = vector<int>(range);
        pow[0]=1;
        for(i=1;i<range;i++){
            pow[i] = (pow[i-1]*26)%prime;
        }
        string ans;
        while(l<=r){
            mid = l + (r-l)/2;
            string dup = rabin(S,mid);
            if(dup.length()>0){
                if(dup.length()>ans.length()){
                    ans = dup;
                    l=mid+1;
                }
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }
    string rabin (string S, int len){
        if(len==0)
            return "";
        int n = S.length(),curr=0;
        unordered_map<int,vector<int>> hm;
        for(int i=0;i<len;i++){
            curr = (curr*26 + (S[i]-'a'))%prime;
        }
        hm[curr]={0};
        for(int i = len;i<n;i++) {
            curr = ((curr - pow[len-1]*(S[i-len]-'a'))%prime + prime)%prime;
            curr = (curr*26 + (S[i]-'a'))%prime;
            if(hm.find(curr)==hm.end()){
                hm[curr]={i-len+1};
            }
            else{
                for(int idx: hm[curr]){
                    if(S.substr(idx,len)==S.substr(i-len+1,len))
                        return S.substr(idx,len);
                }
                hm[curr].push_back({i-len+1});
            }    
        }
        return "";
    }
};
