/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (48.93%)
 * Total Accepted:    356.7K
 * Total Submissions: 712.5K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: m = 7, n = 3
 * Output: 28
 * 
 */
class Solution {
    public int uniquePaths(int m, int n) {
      // 本题是超简单的动态规划
      // 主要是状态转移方程非常简单
      // 到每一步的走法等于左和上两步的走法之和
      int[][] dp = new int[m][n];

      // 初始状态
      for (int i = 0; i < n; i++) dp[0][i] = 1;
      for (int j = 0; j < m; j++) dp[j][0] = 1;

      // 状态转移方程dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          dp[i][j] = dp[i - 1][j] +  dp[i][j - 1];
        }
      }

      return dp[m - 1][n - 1];
    }
}

