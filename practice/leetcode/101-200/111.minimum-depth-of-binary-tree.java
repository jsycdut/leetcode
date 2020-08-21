/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 1);
    }
    
    int dfs(TreeNode root, int height) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return height;
        return Math.min(dfs(root.left, height + 1), dfs(root.right, height + 1));
    }

    public int bfs(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return level;
    }
}
