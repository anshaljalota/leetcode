/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
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
    bool isCousins(TreeNode* root, int x, int y) {
        if(!root)
            return false;
        queue<TreeNode*>q;
        q.push(root);
        int a=-1,b=-1;
        while(!q.empty()){
            int s = q.size();
            a=-1;
            b=-1;
            vector<pair<int,int>> v;
            while(s--){
                TreeNode* parent = q.front();
                q.pop();
                int n = parent->val;
                if(parent->left){
                    q.push(parent->left);
                    v.push_back(make_pair(parent->left->val,n));
                }
                if(parent->right){
                    q.push(parent->right);
                    v.push_back(make_pair(parent->right->val,n));
                }
            }
            for(int i=0;i<v.size();i++){
                if(v[i].first==x){
                    a = v[i].second;
                }
                else if(v[i].first==y){
                    b = v[i].second;
                }
            }
            if( a!=-1 && b!=-1 && a!=b)
                return true;
            else if((a!=-1 || b!=-1) && a==b)
                return false;
        }
        return false;
    }
};
