/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/submissions/
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
    public void flatten(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode last = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            
            if (last == null) {
                last = cur;
            } else {
                last.right = cur;
                last = last.right;
            }
            
            if (cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
            }
        }
    }
}
