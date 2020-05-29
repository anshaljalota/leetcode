/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
*/
class Solution {
public:
    
    int maximalSquare(vector<vector<char>>& matrix) {
        int res=0;
        int row = matrix.size();
        if(row==0)
            return res;
        int col = matrix[0].size();
        if(col==0)
            return res;
        int k;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    int len =1;
                    bool flag = true;
                    while(len+i<row && len+j<col && flag){
                        for(k=j;k<=len+j;k++){
                            if(matrix[i+len][k]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        for(k=i;k<=len+i;k++){
                            if(matrix[k][len+j]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            len++;
                    }
                    res = max(len,res);
                }
                
            }
        }
        return res*res;
    }
};
