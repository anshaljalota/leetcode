/*

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
*/

class Solution {
    public int numTrees(int n) {
        if(n==0 || n==1)
            return 1;
        int[] al = new int[n+1];
        al[0]=1;
        al[1]=1;
        int i,j,val;
        for(i=2;i<n+1;i++){
            val=0;
            for(j=0;j<i;j++){
                val+=al[j]*al[i-j-1];
            }
            al[i]=val;
        }
        return al[n];
    }
}
