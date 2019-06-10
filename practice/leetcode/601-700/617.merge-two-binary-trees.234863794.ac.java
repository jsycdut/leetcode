/*
 * @lc app=leetcode id=617 lang=java
 *
 * [617] Merge Two Binary Trees
 *
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 *
 * algorithms
 * Easy (70.24%)
 * Total Accepted:    178.4K
 * Total Submissions: 254K
 * Testcase Example:  '[1,3,2,5]\n[2,1,3,null,4,null,7]'
 *
 * Given two binary trees and imagine that when you put one of them to cover
 * the other, some nodes of the two trees are overlapped while the others are
 * not.
 * 
 * You need to merge them into a new binary tree. The merge rule is that if two
 * nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * Tree 1                     Tree 2                  
 * ⁠         1                         2                             
 * ⁠        / \                       / \                            
 * ⁠       3   2                     1   3                        
 * ⁠      /                           \   \                      
 * ⁠     5                             4   7                  
 * Output: 
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \ 
 * 5   4   7
 * 
 * 
 * 
 * 
 * Note: The merging process must start from the root nodes of both trees.
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

      // 树都是递归的处理，所以只需要处理最基础的情况就行了
      // 当同一位置的两个节点，只要有空，直接返回另一个
      // 两个都是null的时候返回的也是null
      // 然后就是两个都不为空的情况
      // 此时直接处理该节点，然后递归处理左右子节点就行了
      // 此解法最后返回的是将t2合并到t1上的t1
      //
      // 递归出口，遇到null的就返回另一个节点
      if (t1 == null) return t2;
      if (t2 == null) return t1;

      t1.val = t1.val + t2.val;

      t1.left = mergeTrees(t1.left, t2.left);
      t1.right = mergeTrees(t1.right, t2.right);

      return t1;
    }
}

