/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int res=0;
        int row=grid.size();
        if(row==0)
            return res;
        int col = grid[0].size();
        if(col==0)
            return res;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    void dfs(vector<vector<char>>& grid, int x, int y){
        if(grid[x][y]=='0')
            return;
        grid[x][y]='0';
        if(check(grid,x+1,y)){
            dfs(grid,x+1,y);
        }
        if(check(grid,x-1,y)){
            dfs(grid,x-1,y);
        }
        if(check(grid,x,y+1)){
            dfs(grid,x,y+1);
        }
        if(check(grid,x,y-1)){
            dfs(grid,x,y-1);
        }
    }
    bool check(vector<vector<char>>& grid, int x, int y){
        if(x>=0 && x<grid.size() && y>=0 && y<grid[0].size() && grid[x][y]=='1')
            return true;
        return false;
    }
    
};
