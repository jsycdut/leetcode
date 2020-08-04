/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/ 
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
    int ans = -1;
    int cnt = 1;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return -1;
        dfs(root, k);
        return ans;
    }

    void dfs(TreeNode root, int k) {
        if (root == null || cnt > k) return;
        dfs(root.left, k);
        if (cnt == k) ans = root.val;
        cnt++;
        dfs(root.right, k);
    }
}
