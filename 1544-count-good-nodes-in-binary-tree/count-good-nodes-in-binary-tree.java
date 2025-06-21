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
    public int goodNodes(TreeNode root) {
        return helper(root,0,Integer.MIN_VALUE);
    }
    public int helper(TreeNode root ,int ans , int mx){
        if(root==null) return 0;
        int rootans = 0 ;
        if(root.val>=mx){
            mx=root.val;
            rootans = 1;
        }
        int leftans = helper(root.left , ans , mx);
        int rightans = helper(root.right ,ans ,mx);
        ans= rightans+leftans+rootans ; 
        return ans ; 
    }
}