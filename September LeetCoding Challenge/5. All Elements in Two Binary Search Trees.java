/*

Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.
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
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
       List<Integer> l1=new ArrayList<>();
       List<Integer> l2=new ArrayList<>();
        inord(root1,l1);
        inord(root2,l2);
        List<Integer> l3 = new ArrayList<>();
        int i=0,j=0;
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)<l2.get(j)){
                l3.add(l1.get(i));
                i++;
            }
            else{
                l3.add(l2.get(j));
                j++;
            }
        }
        while(i<l1.size()){
            l3.add(l1.get(i));
                i++;
        }
        while(j<l2.size()){
            l3.add(l2.get(j));
                j++;
        }
        //Collections.sort(l3);
        return l3;
    }
    
    void inord(TreeNode root, List<Integer> li){
        if(root==null)
            return;
        inord(root.left,li);
        li.add(root.val);
        inord(root.right,li);
    }
}
