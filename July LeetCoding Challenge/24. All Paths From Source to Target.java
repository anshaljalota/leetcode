/*

Given a directed acyclic graph of N nodes. Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
*/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> li = new ArrayList<>();
        dfs(graph,0,graph.length-1,li,res);
        return res;
    }
    void dfs(int[][] graph,int src,int dest,List<Integer> li, List<List<Integer>> res){
        if(src==dest){
            res.add(li);
        }
        
            li.add(src);
            for(int val: graph[src]){
                List<Integer> temp_li = new ArrayList<>(li);
                dfs(graph,val,dest,temp_li,res);
            }
        
    }
}
