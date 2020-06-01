/*
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
*/
class Solution {
public:
    int sum(vector<int> vec){
        int range = vec.size();
        int curr_sum=vec[0],max_sum=vec[0];
        for(int i=1;i<range;i++){
            if(curr_sum+vec[i]>vec[i]){
                curr_sum+=vec[i];
            }
            else{
                curr_sum=vec[i];
            }
            max_sum = max(max_sum,curr_sum);
        }
        return max_sum;
    }
    int maxSubarraySumCircular(vector<int>& A) {
        int range = A.size();
        if(range==0)
            return 0;
        vector<int> vec,vec_neg;
        for(int i=0;i<range;i++)
            vec.push_back(A[i]);
        int val1,val2,total=0;
        val1 = sum(vec);
        
        for(int i=0;i<range;i++){
            total+=A[i];
            vec_neg.push_back(A[i]*-1);
        }
        val2 = total + sum(vec_neg);
        
        if(val2==0)
            return val1;
        return max(val1,val2);
        
    }
};
