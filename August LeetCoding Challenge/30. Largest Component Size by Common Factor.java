/*

Given a non-empty array of unique positive integers A, consider the following graph:

There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.
*/

class Solution {
    public int largestComponentSize(int[] A) {
        Map<Integer,Integer> par = new HashMap<>();
        
        for(int val: A){
            for(int i=2;i*i<=val;i++){
                if(val%i==0){
                    union(val,i,par);
                    union(val,val/i,par);
                }
            }
        }
        
        int max_res=1;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int val: A){
            int f = find(val,par);
            if(freq.containsKey(f)){
                freq.put(f,freq.get(f)+1);
                max_res= Math.max(max_res,freq.get(f));
            }
            else{
                freq.put(f,1);
            }
        }
        return max_res;
    }
    
    void union(int i, int j, Map<Integer,Integer> par){
        int x = find(i,par);
        int y = find(j,par);
        if(x<y){
            par.put(y,x);
        }
        else{
            par.put(x,y);
        }
    }
    
    int find(int i, Map<Integer,Integer> par){
        if(par.get(i)==null){
            par.put(i,i);
        }
        while(i!=par.get(i)){
            i=par.get(i);
        }
        return i;
    }
}
