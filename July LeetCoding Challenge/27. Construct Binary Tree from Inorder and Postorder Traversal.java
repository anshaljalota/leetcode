/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    int post_idx;
    HashMap<Integer,Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post_idx = postorder.length-1;
        int i,range = inorder.length;
        for(i=0;i<range;i++){
            hm.put(inorder[i],i);
        }
        if(range>0)
            return util(postorder,0,range-1);
        return null;
    }
    TreeNode util(int[] postorder,int start, int end){
        if(start>end)
            return null;
        TreeNode node = new TreeNode(postorder[post_idx]);
        post_idx--;
        if(start==end)
            return node;
        int idx = hm.get(node.val);
        node.right = util(postorder,idx+1,end);
        node.left = util(postorder,start,idx-1);
        return node;
    }
}
