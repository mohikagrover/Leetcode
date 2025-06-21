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
    public int helper(TreeNode root ,int ans , int max){
        if(root==null) return 0;
        int rootans = 0 ;
        if(root.val>=max){
            max=root.val;
            rootans = 1;
        }
        int left = helper(root.left , ans , max);
        int right = helper(root.right ,ans ,max);
        ans= right+left+rootans ; 
        return ans ; 
    }
}