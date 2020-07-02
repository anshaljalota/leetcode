/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
*/

class Solution {
public:
    void solve(vector<vector<char>>& board) {
        int r = board.size();
        if(r==0)
            return;
        int c = board[0].size(),i,j;
        if(c==0)
            return;
        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                if(board[i][j]=='O')
                    board[i][j]='-';
            }
        }
        for(i=0;i<r;i++){
            if(board[i][0]=='-')
                dfs(board,i,0);
        }
        for(i=0;i<r;i++){
            if(board[i][c-1]=='-')
                dfs(board,i,c-1);
        }
        for(i=0;i<c;i++){
            if(board[0][i]=='-')
                dfs(board,0,i);
        }
        for(i=0;i<c;i++){
            if(board[r-1][i]=='-')
                dfs(board,r-1,i);
        }
        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                if(board[i][j]=='-')
                    board[i][j]='X';
            }
        }
    }
    void dfs(vector<vector<char>>& board, int x, int y){
        if(x<0||x>=board.size()||y<0||y>=board[0].size())
            return;
        if(board[x][y]!='-')
            return;
        board[x][y]='O';
        dfs(board,x+1,y);
        dfs(board,x-1,y);
        dfs(board,x,y+1);
        dfs(board,x,y-1);
    }
};
