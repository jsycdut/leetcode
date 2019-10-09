/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (50.46%)
 * Total Accepted:    312K
 * Total Submissions: 618.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 *
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 *
 * Output: [1,2,3]
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
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
    // 递归办法的前序遍历
    // 其实二叉树的前序-中序-后序遍历指的是根节点的出现顺序
    // 前序遍历是 根 左 右
    // 中序遍历是 左 根 右
    // 后序遍历是 左 右 根
    public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

            recur(root, list);
            return list;
    }

    void recur(TreeNode node, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);
        recur(node.left, list);
        recur(node.right, list);
    }

    // 迭代求解，利用栈，在Java里用Deque做栈，不采用Stack这个类
    public List<Integer> preorderTraversal(TreeNode root) {
      if (root == null) return Collections.emptyList();

      Deque<TreeNode> q = new ArrayDeque<>();
      List<Integer> ans = new ArrayList<>();

      q.offerFirst(root);

      while (! q.isEmpty()) {
        TreeNode node = q.poll();
        ans.add(node.val);

        // 栈，先入右节点，后左节点
        // 要检查null，因为Queue不允许null元素
        if (node.right != null) q.offerFirst(node.right);
        if (node.left != null) q.offerFirst(node.left);
      }

      return ans;
    }
}

