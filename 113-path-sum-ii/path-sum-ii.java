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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        solve(root, 0, targetSum, new ArrayList<>(), res);
        return res;
    }

    public void solve(TreeNode root, int sum, int target, List<Integer> curr, List<List<Integer>> res) {
        if (root == null) return;

        curr.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(curr));
            }
        }

        solve(root.left, sum, target, curr, res);
        solve(root.right, sum, target, curr, res);
        curr.remove(curr.size() - 1);
    }
}
