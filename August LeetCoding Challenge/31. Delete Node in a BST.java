/*

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Follow up: Can you solve it with time complexity O(height of tree)?
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
         if(root.val>key){
             root.left = deleteNode(root.left,key);
         }
        else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            root.val = util(root.right);
            root.right = deleteNode(root.right,root.val);
        }
        return root;
    }
    int util(TreeNode root){
        return root.left==null?root.val:util(root.left);
    }
}
