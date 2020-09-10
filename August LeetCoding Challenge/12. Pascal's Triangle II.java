/*

Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.

Notice that the row index starts from 0.
*/

class Solution {
    int util(int n, int r){
        int i=0;
        long res=1;
        if(r>n-r){
            r = n-r;
        }
        for(i=0;i<r;i++){
            res *=(n-i);
            res/=(i+1);
        }
        return (int)res;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            res.add(util(rowIndex,i));
        }
        return res;
    }
}
