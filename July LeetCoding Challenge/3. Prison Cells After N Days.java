/*

There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
*/
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N=(N-1)%14 +1;
        for(int i=0;i<N;i++){
            cells = util(cells);
        }
        return cells;
    }
    public int[] util(int []cells){
        int [] temp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            if(cells[i-1]==cells[i+1])
                temp[i]=1;
            else
                temp[i]=0;
        }
        return temp;
    }
}
