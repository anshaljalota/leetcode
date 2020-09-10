/*

Find the sum of all left leaves in a given binary tree.
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
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        util(root);
        return sum;
    }
    void util(TreeNode root){
        if(root==null)
            return;
        util(root.left);
        if(root.left!=null && root.left.left==null && root.left.right==null)
            sum+=root.left.val;
        util(root.right);
    }
}
