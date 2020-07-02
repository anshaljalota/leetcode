/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
*/
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int i,j,k,range = words.length;
        for(i=0;i<range;i++){
            if(check(board,words[i]))
                res.add(words[i]);
        }
        return res;
    }
    boolean check(char[][] board, String word){
        for(int j=0;j<board.length;j++){
                for(int k=0;k<board[j].length;k++){
                    if(board[j][k]==word.charAt(0)){
                        if(dfs(word,board,j,k,1)){
                            return true;
                        }
                    }
                }
            }
        return false;
    }
    boolean dfs(String str, char[][] board, int x, int y, int idx){
        
        if(idx == str.length())
            return true;
        board[x][y]='.';
        if(x>0 && board[x-1][y]==str.charAt(idx) && dfs(str,board,x-1,y,idx+1)){
            board[x][y]= str.charAt(idx-1);
            return true;
        }
        if(x<board.length-1 && board[x+1][y]==str.charAt(idx) && dfs(str,board,x+1,y,idx+1)){
            board[x][y]= str.charAt(idx-1);
            return true;
        }
        if(y>0 && board[x][y-1]==str.charAt(idx) && dfs(str,board,x,y-1,idx+1)){
            board[x][y]= str.charAt(idx-1);
            return true;
        }
        if(y<board[0].length-1 && board[x][y+1]==str.charAt(idx) && dfs(str,board,x,y+1,idx+1)){
            board[x][y]= str.charAt(idx-1);
            return true;
        }
        board[x][y]=str.charAt(idx-1);
        return false;
    }
}
