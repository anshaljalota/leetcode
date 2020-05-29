/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
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
    int pre_idx;
    unordered_map<int,int> um;
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        int n = preorder.size();
        vector<int> inorder = preorder;
        sort(inorder.begin(),inorder.end());
        for(int i=0;i<n;i++)
            um[inorder[i]]=i;
        pre_idx=0;
        TreeNode * root = util(preorder,0,n-1);
        return root;
    }
    TreeNode *util(vector<int>& preorder, int start, int end){
        if(start>end)
            return NULL;
        TreeNode *root = (TreeNode*) new TreeNode(preorder[pre_idx]);
        int idx = um[preorder[pre_idx]];
        pre_idx++;
        root->left = util(preorder,start,idx-1);
        root->right = util(preorder,idx+1,end);
        return root;
    }
};
