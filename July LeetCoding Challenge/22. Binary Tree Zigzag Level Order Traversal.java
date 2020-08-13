/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        List<Integer> li ;
        while(!q.isEmpty()){
            li = new ArrayList<>();
            int s = q.size();
            flag = !flag;
            while(s-->0){
                TreeNode t = q.poll();
                li.add(t.val);
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
            }
            if(!flag)
                Collections.reverse(li);
            res.add(li);
        }
        return res;
    }
}
