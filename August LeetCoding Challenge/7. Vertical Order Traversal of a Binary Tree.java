/*

Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CustPair implements Comparable<CustPair>{
    int val;
    int h;
    public CustPair(int val, int h){
        this.val = val;
        this.h = h;
    }
    @Override
    public int compareTo(CustPair c){
        return (this.h==c.h)?this.val-c.val:this.h-c.h;
    }
}
class Solution {
    HashMap<Integer,List<CustPair>> hm = new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        util(root,0,0);
        List<Integer> keys = new ArrayList<Integer>(hm.keySet());
        Collections.sort(keys);
        for(int key:keys){
            List<CustPair> li = hm.get(key);
            Collections.sort(li);
            List<Integer> list1 = new ArrayList<>();
            for(CustPair cp : li)
                list1.add(cp.val);
            res.add(list1);
        }
        return res;
    }
    void util(TreeNode root, int h, int v){
        if(root==null)
            return;
        if(!hm.containsKey(v)){
            hm.put(v,new ArrayList<>());
        }
        hm.get(v).add(new CustPair(root.val,h));
        util(root.left,h+1,v-1);
        util(root.right,h+1,v+1);
    }
}
