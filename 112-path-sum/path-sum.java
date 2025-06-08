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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, 0,targetSum);
        
    }
    public boolean solve(TreeNode root, int sum, int target){
        if(root==null)  return false;
        if(root.left==null && root.right==null){
            sum+=root.val;
            if(sum==target){
                return true;
            }
        }
        sum+=root.val;

        boolean l=solve(root.left, sum,target);
        boolean r= solve(root.right,sum,target);

        return l||r;
    }
}