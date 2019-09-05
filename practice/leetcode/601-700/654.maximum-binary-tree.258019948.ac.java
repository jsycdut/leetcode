/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
 *
 * https://leetcode.com/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (76.97%)
 * Total Accepted:    96K
 * Total Submissions: 124.7K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * 
 * Given an integer array with no duplicates. A maximum tree building on this
 * array is defined as follow:
 * 
 * The root is the maximum number in the array. 
 * The left subtree is the maximum tree constructed from left part subarray
 * divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray
 * divided by the maximum number. 
 * 
 * 
 * 
 * 
 * Construct the maximum tree by the given array and output the root node of
 * this tree.
 * 
 * 
 * Example 1:
 * 
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * 
 * ⁠     6
 * ⁠   /   \
 * ⁠  3     5
 * ⁠   \    / 
 * ⁠    2  0   
 * ⁠      \
 * ⁠       1
 * 
 * 
 * 
 * Note:
 * 
 * The size of the given array will be in the range [1,1000].
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      // 简单递归的应用
      // 题意是给一个有序数组，然后找到里面最大的，作为树根
      // 然后在左边找最大的做左子节点，右边找最大的做右子节点
      // 简单递归即可
      if (nums == null || nums.length == 0) return null;

      int len = nums.length;

      return recur(nums, 0, len - 1);
    }

    TreeNode recur(int[] nums, int start, int end) {
      if (start == end) {
        return new TreeNode(nums[start]);
      }

      int max = start;

      for (int i = start; i <= end; i++) {
        if (nums[i] > nums[max]) max = i;
      }
      
      TreeNode node = new TreeNode(nums[max]);

      if (start < max) node.left = recur(nums, start, max - 1);
      if (max < end) node.right = recur(nums, max + 1, end);

      return node;
    }
}

