/*

You are given two images img1 and img2 both of size n x n, represented as binary, square matrices of the same size. (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?
*/

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int res=0;
        for(int row=-A.length+1;row<A.length;row++){
            for(int col=-A[0].length+1;col<A[0].length;col++){
                res = Math.max(res,util(A,B,row,col));
            }
        }
        return res;
    }
    int util(int[][] A, int[][] B, int x, int y){
        int count=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if((i+x<0)||(i+x>=A.length)||(j+y<0)||(j+y>=A[0].length)||(A[i][j]+B[i+x][j+y]!=2))
                    continue;
                count++;
            }
        }
        return count;
    }
}
