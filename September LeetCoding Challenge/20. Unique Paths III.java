/*

On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
*/

class Solution {
    int rows,cols,res;
    int [][]grid;
    public int uniquePathsIII(int[][] grid) {
        this.rows=grid.length;
        this.cols=grid[0].length;
        int valid_paths=0,start_row=0,start_col=0;
        this.res=0;
        this.grid=grid;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                int cell = grid[row][col];
                if(cell>=0){
                    valid_paths++;
                }
                if(cell==1){
                    start_row=row;
                    start_col=col;
                }
            }
        }
        util(start_row,start_col,valid_paths);
        return this.res;
    }
    
    void util(int row, int col, int remain){
        if(grid[row][col]==2 && remain==1){
            this.res+=1;
            return;
        }
        int temp = grid[row][col];
        grid[row][col]=-4;
        remain-=1;
        int []row_offset={0,0,1,-1};
        int []col_offset={1,-1,0,0};
        for(int i=0;i<4;i++){
            int next_row = row + row_offset[i];
            int next_col = col + col_offset[i];
            if(next_row<0 || next_row>=this.rows||next_col<0 || next_col>=this.cols)
                continue;
            if(grid[next_row][next_col]<0)
                continue;
            util(next_row,next_col,remain);
        }
        grid[row][col]=temp;
    }
}
