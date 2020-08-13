/*

Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        int res=0;
        while(!dq.isEmpty()){
            int s = dq.size();
            res = Math.max(res,s);
            while(s-->0){
                TreeNode t = dq.poll();
                if(t==null){
                    dq.add(null);
                    dq.add(null);
                }
                else{
                    dq.add(t.left);
                    dq.add(t.right);
                }
            }
            while(!dq.isEmpty()&&dq.peekFirst()==null)
                dq.pollFirst();
            while(!dq.isEmpty()&&dq.peekLast()==null)
                dq.pollLast();
        }
        return res;
    }
}
