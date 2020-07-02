/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.
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
    int sum  = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        return util(root,0);
    }
    int util(TreeNode root, int sum){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            return sum*10 + root.val;
        }
        return util(root.right,root.val+sum*10) + util(root.left,sum*10 + root.val);
    }
}
