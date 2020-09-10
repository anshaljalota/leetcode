/*

Given an array of integers arr, sort the array by performing a series of pancake flips.

In one pancake flip we do the following steps:

Choose an integer k where 1 <= k <= arr.length.
Reverse the sub-array arr[1...k].
For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.

Return the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.
*/

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for(int val=A.length;val>0;val--){
            int idx = find(A,val);
            if(idx==val-1){
                continue;
            }
            if(idx!=0){
                res.add(idx+1);
                flip(A,idx+1);
            }
            res.add(val);
            flip(A,val);
        }
        return res;
    }
    int find(int[] arr, int val){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val)
                return i;
        }
        return -1;
    }
    void flip(int [] arr, int val){
        int i=0;
        while(i<val/2){
            int temp=arr[i];
            arr[i] = arr[val-i-1];
            arr[val-i-1]=temp;
            i++;
        }
    }
}
