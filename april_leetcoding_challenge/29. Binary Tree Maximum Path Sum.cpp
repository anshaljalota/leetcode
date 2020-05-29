/*
Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int res = INT_MIN;
    int util(TreeNode* root){
        if(!root)
            return 0;
        int l = max(util(root->left),0);
        int r = max(util(root->right),0);
        int val = root->val + l + r;
        res = max(res,val);
        return root->val + max(l,r);
    }
    int maxPathSum(TreeNode* root) {
        util(root);
        return res;
        
    }
};
