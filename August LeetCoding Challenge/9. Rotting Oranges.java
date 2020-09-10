/*


In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
*/

class Solution {
    class Pair{
        int first,second;
        Pair(int first, int second){
            this.first  = first;
            this.second = second;
        }
    }
    boolean isSafe(int x, int y, int row, int col){
        if(x<0||x>=row||y<0||y>=col)
            return false;
        return true;
    }
    boolean isFlag(Pair pr){
        return (pr.first==-1 && pr.second==-1);
    }
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int i,j,res=0;
        Queue<Pair> q = new LinkedList<>();
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        q.add(new Pair(-1,-1));
        Pair pr;
        while(!q.isEmpty()){
            boolean flag = false;
            while(!isFlag(q.peek())){
                pr = q.peek();
                if(isSafe(pr.first + 1, pr.second,row,col) && grid[pr.first + 1][pr.second]==1){
                    if(!flag){
                        flag = true;
                        res++;
                    }
                    grid[pr.first + 1][pr.second]=2;
                    q.add(new Pair(pr.first + 1,pr.second));
                    
                }
                if(isSafe(pr.first - 1, pr.second,row,col) && grid[pr.first - 1][pr.second]==1){
                    if(!flag){
                        flag = true;
                        res++;
                    }
                    grid[pr.first - 1][pr.second]=2;
                    q.add(new Pair(pr.first - 1,pr.second));
                    
                }
                if(isSafe(pr.first, pr.second+1,row,col) && grid[pr.first][pr.second+1]==1){
                    if(!flag){
                        flag = true;
                        res++;
                    }
                    grid[pr.first][pr.second+1]=2;
                    q.add(new Pair(pr.first,pr.second+1));
                    
                }
                if(isSafe(pr.first, pr.second-1,row,col) && grid[pr.first][pr.second-1]==1){
                    if(!flag){
                        flag = true;
                        res++;
                    }
                    grid[pr.first][pr.second-1]=2;
                    q.add(new Pair(pr.first,pr.second-1));
                    
                }
                q.poll();
            }
            q.poll();
            if(!q.isEmpty()){
              q.add(new Pair(-1,-1));  
            }
        }
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return res;
    }
}
