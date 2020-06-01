/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
*/
class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        int row = matrix.size();
        if(row==0)
            return 0;
        int col = matrix[0].size();
        if(col==0)
            return 0;
        int a,b,c,i,j,res=0,val;
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(matrix[i][j]==1)
                    res+=1;
            }
        }
        for(i=1;i<row;i++){
            for(j=1;j<col;j++){
                if(matrix[i][j]>0){
                    a = matrix[i-1][j-1];
                    b = matrix[i-1][j];
                    c = matrix[i][j-1];
                    val = matrix[i][j];
                    if(a>0 && b>0 && c>0){
                        matrix[i][j]+=min(a,min(b,c));
                        res+= matrix[i][j]-val;
                    }
                }
            }
        }
        return res;
    }
};
