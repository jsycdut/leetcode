/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int ans = -1;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    List<Integer> dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return Arrays.asList(root.val, root.val);
        }
        int val = root.val;
        // 遍历左子树和右子树，分别找出其最大值和最小值，用于更新max值，
        int min = val;
        int max = val;
        if (root.left != null) {
            List<Integer> l = dfs(root.left);
            for (int i : l) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }

            ans = Math.max(ans, Math.max(Math.abs(val - min), Math.abs(val - max)));
        }

        if (root.right != null) {
            List<Integer> r = dfs(root.right);
            for (int i : r) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
            ans = Math.max(ans, Math.max(Math.abs(val - min), Math.abs(val - max)));
        }

        return Arrays.asList(min, max);
    }
}
