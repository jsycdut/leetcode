/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (30.38%)
 * Total Accepted:    231.9K
 * Total Submissions: 763.2K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      if (matrix == null || matrix.length == 0) return Collections.emptyList();

      // 解法I：用一个二维状态数组，表示矩阵中元素的访问情况
      // 然后使用0 1 2 3表示向右 向下 向左 向上
      // 遇到数组边界，或者已经访问过的元素，就改变方向
      // 由于当前方向已知，又是螺旋访问数组，所以改变后的方向也已知
      // 注意撞墙的时候，要将下一个要访问的坐标更新为正确的坐标
      // 特别注意，数组边界和已访问是同样的处理情况
      List<Integer> list = new ArrayList<>();

      // direction: 0 1 2 3
      // 0: right
      // 1: down
      // 2: left
      // 3: up

      // 访问数据的方向常量定义
      final int RIGHT = 0;
      final int DOWN = 1;
      final int LEFT = 2;
      final int UP = 3;

      int direction = RIGHT;

      int m = 0;
      int n = 0;

      int rows = matrix.length;
      int cols = matrix[0].length;

      boolean[][] flag = new boolean[rows][cols];

      int total = rows * cols;
      int count = 0;

      while (count < total) {
        switch(direction) {
          case 0:
            if (!flag[m][n]) {
              list.add(matrix[m][n]);
              flag[m][n] = true;
              count++;
              n++;
            }
            
            if (n == cols || flag[m][n]) {
              n--;
              m++;
              direction = DOWN;
            }
            break;

          case 1:
            if (!flag[m][n]) {
              list.add(matrix[m][n]);
              flag[m][n] = true;
              count++;
              m++;
            }

            if (m == rows || flag[m][n]) {
              m--;
              n--;
              direction = LEFT;
            }

            break;

          case 2:
            if (!flag[m][n]) {
              list.add(matrix[m][n]);
              flag[m][n] = true;
              count++;
              n--;
            }

            if (n == -1 || flag[m][n]) {
              m--;
              n++;
              direction = UP;
            }

            break;

          case 3:
            if (!flag[m][n]) {
              list.add(matrix[m][n]);
              flag[m][n] = true;
              count++;
              m--;
            }

            if (flag[m][n]) { // m最多为0，不会取-1这个值，因为是从(0, 0)开始的
              m++;
              n++;
              direction = RIGHT;
            }

            break;

          default:
            break;
        }
      }

      return list;
    }
}

