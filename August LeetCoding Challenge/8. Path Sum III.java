/*

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
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
    int res;
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        res=0;
        util(root,sum);
        return res;
    }
    void util(TreeNode root, int sum){
        if(root==null)
            return;
        checkSum(root,sum);
        util(root.left,sum);
        util(root.right,sum);
    }
    void checkSum(TreeNode root, int sum){
        if(root==null)
            return;
        if(sum==root.val){
            res++;
        }
        checkSum(root.left,sum-root.val);
        checkSum(root.right,sum-root.val);
    }
}
