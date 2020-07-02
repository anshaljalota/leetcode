/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
*/
class Solution {
public:
    void util(vector<int>&v, string &ans,vector<int> val,int n, int k){
        if(n==1){
            ans+=to_string(v.back());
            return;
        }
        int idx = k/val[n-1];
        if(k%val[n-1]==0){
            idx--;
        }
        ans+=to_string(v[idx]);
        v.erase(v.begin()+idx);
        k-= val[n-1]*idx;
        util(v,ans,val,n-1,k);
    }
    string getPermutation(int n, int k) {
        if(n==1)
            return "1";
        vector<int> v,val={1,1,2,6,24,120,720,5040,40320,362880};
        string ans="";
        for(int i=1;i<=n;i++){
            v.emplace_back(i);
        }
        util(v,ans,val,n,k);
        return ans;
    }
};
