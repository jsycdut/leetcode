/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (47.60%)
 * Total Accepted:    250.7K
 * Total Submissions: 521.5K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
      // 二维矩阵从左上角到右下角的最小路径和
      // 典型的dp题，状态转移方程为
      // dp[row][col] = min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col]
      if (grid == null || grid.length == 0) return -1;

      // dp
      int[][] dp = new int[grid.length][grid[0].length];

      int sum = 0;
      int i = 0;

      // initialize 1st row
      while (i < grid[0].length) {
        sum += grid[0][i];
        dp[0][i] = sum;
        i++;
      }

      sum = 0;
      i = 0;

      // initialize 1st col
      while (i < grid.length) {
        sum += grid[i][0];
        dp[i][0] = sum;
        i++;
      }

      for (int row = 1; row < dp.length; row++) {
        for (int col = 1; col < dp[0].length; col++) {
          dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
        }
      }

      return dp[dp.length - 1][dp[0].length - 1];
    }
}


