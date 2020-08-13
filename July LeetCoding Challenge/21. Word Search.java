/*

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if(row==0)
            return false;
        int col = board[0].length;
        if(col==0)
            return false;
        int i,j;
        boolean flag;
        boolean[][] visit = new boolean[row][col];
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    flag = dfs(board,i,j,0,word);
                    if(flag)
                        return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, int x, int y, int idx,String word){
        if(idx == word.length())
            return true;
        if(x<0|| x>=board.length||y<0|| y>=board[0].length)
            return false;
        if(board[x][y]==word.charAt(idx)){
            char ch = board[x][y];
            board[x][y]='\0';
            boolean res = dfs(board,x+1,y,idx+1,word)||
                dfs(board,x-1,y,idx+1,word)||
                dfs(board,x,y+1,idx+1,word)||
                dfs(board,x,y-1,idx+1,word);
            board[x][y]=ch;
            return res;
        }
        return false;
    }
}
