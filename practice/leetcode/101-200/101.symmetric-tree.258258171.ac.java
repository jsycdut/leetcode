/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (44.23%)
 * Total Accepted:    453.7K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3] is not:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
      // 这道题考的是二叉树翻转
      // 如果二叉树是镜像的，翻转了必定和原来一样
      // 先翻转，然后比较
      
      // copy reverse compare三步骤
     
      if (root == null) return true;

      TreeNode copy = new TreeNode(root.val);

      copy(root, copy);

      reverse(copy);

      return compare(root, copy);
    }

    public void copy(TreeNode root, TreeNode copy) {
      if (root == null) return;

      if (root.left != null) copy.left = new TreeNode(root.left.val);
      if (root.right != null) copy.right = new TreeNode(root.right.val);

      copy(root.left, copy.left);
      copy(root.right, copy.right);
    }

    public void reverse(TreeNode root) {
      if (root == null) return;

      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;

      reverse(root.left);
      reverse(root.right);
    }

    public boolean compare(TreeNode root, TreeNode copy) {
      if (root == null && copy == null) {
        return true;
      } else if (root!= null && copy != null && root.val == copy.val) {
        return compare(root.left, copy.left) && compare(root.right, copy.right);
      } else {
        return false;
      }
    }
}

