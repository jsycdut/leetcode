/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (46.48%)
 * Total Accepted:    135.5K
 * Total Submissions: 291.6K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
      if (n <= 0) return new int[0][0];
      
      // 给一个n * n的数组用螺旋的顺序赋值为1 ~ n * n
      // 类似leetcode 54题
      int[][] ans = new int[n][n];

      final int RIGHT = 0;
      final int DOWN = 1;
      final int LEFT = 2;
      final int UP = 3;

      int direction = RIGHT;
      
      int row = 0;
      int col = 0;

      int total = n * n;
      int count = 1;

      while (count <= total) {
        switch(direction) {
          case RIGHT:
            if (ans[row][col] == 0) {
              ans[row][col] = count++;
              col++;
            } 

            if (col == n || ans[row][col] != 0) {
              col--;
              row++;
              direction = DOWN;
            }
          break;

          case DOWN:
          if (ans[row][col] == 0) {
            ans[row][col] = count++;
            row++;
          }

          if (row == n || ans[row][col] != 0) {
            row--;
            col--;
            direction = LEFT;
          }

          break;

          case LEFT:
          if (ans[row][col] == 0) {
            ans[row][col] = count++;
            col--;
          }

          if (col == -1 || ans[row][col] != 0) {
            col++;
            row--;
            direction = UP;
          }

          break;

          case UP:
          if (ans[row][col] == 0) {
            ans[row][col] = count++;
            row--;
          }

          if (ans[row][col] != 0) {
            row++;
            col++;
            direction = RIGHT;
          }

          break;

          default: break;
        }
      }

      return ans;
    }
}

