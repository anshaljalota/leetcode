/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    
    int diameterOfBinaryTree(TreeNode* root) {
        int dia=0; 
        if(!root)
             return 0;
         inord(root,dia);
        return dia;
    }
    int inord(TreeNode* node, int &dia){
        if(!node)
            return 0;
        int l = inord(node->left,dia);
        int r = inord(node->right,dia);
        dia = max(dia,l+r);
        return max(l,r)+1;
    }
};
