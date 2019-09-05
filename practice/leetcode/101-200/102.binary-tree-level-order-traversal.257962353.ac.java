/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (49.88%)
 * Total Accepted:    425K
 * Total Submissions: 851.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
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
    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) return Collections.emptyList();

      Queue<TreeNode> queue = new ArrayDeque<>();
      Queue<TreeNode> pool = new ArrayDeque<>();

      List<List<Integer>> res = new ArrayList<>();
      List<Integer> temp = new ArrayList<>();
      
      queue.offer(root);

      while (!queue.isEmpty()) {
        TreeNode node = queue.remove();

	temp.add(node.val);

	if (node.left != null) pool.offer(node.left);
	if (node.right != null) pool.offer(node.right);

        if (queue.isEmpty()) {
          res.add(new ArrayList<>(temp));
          temp.clear();

	  while (!pool.isEmpty()) {
	    queue.offer(pool.remove());
	  }
	}
      }

      return res;
    }
}

