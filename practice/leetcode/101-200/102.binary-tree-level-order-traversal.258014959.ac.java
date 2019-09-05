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

      List<List<Integer>> res = new LinkedList<>();

      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
	// size 保存当前层节点的数量，下面按照这个来从queue中抽取对应数量的节点
        int size = queue.size();

	List<Integer> list = new LinkedList<>();

	for (int i = 0; i < size; i++) {
	  TreeNode node = queue.poll();
	  list.add(node.val);

	  if (node.left != null) queue.offer(node.left);
	  if (node.right != null) queue.offer(node.right);
	}

	res.add(new LinkedList<>(list));
      }

      return res;
    }
}

