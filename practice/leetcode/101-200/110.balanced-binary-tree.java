/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }
}
