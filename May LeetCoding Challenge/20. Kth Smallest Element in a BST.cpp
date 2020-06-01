/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
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
    vector<int > vec;
    int kthSmallest(TreeNode* root, int k) {
        inord(root);
        return vec[k-1];
    }
    void inord(TreeNode* root){
        if(!root)
            return;
        inord(root->left);
        vec.push_back(root->val);
        inord(root->right);
    }
};
