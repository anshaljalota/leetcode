/*

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
*/
class Solution {
    int res = 0;
    public int islandPerimeter(int[][] grid) {
        int r = grid.length;
        if(r==0)
            return 0;
        int c = grid[0].length;
        if(c==0)
            return 0;
        int i,j;
        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                if(grid[i][j]==1)
                    dfs(grid,i,j);
            }
        }
        return res;
    }
    void dfs(int[][] grid, int x, int y){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==0){
            res++;
            return;
        }
        if(grid[x][y]==-1)
            return;
        grid[x][y]=-1;
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }
}
