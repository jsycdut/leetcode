/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 *
 * https://leetcode.com/problems/rotate-image/description/
 *
 * algorithms
 * Medium (47.15%)
 * Total Accepted:    235.2K
 * Total Submissions: 495.8K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 *
 * Example 1:
 *
 *
 * Given input matrix =
 * [
 * ⁠ [1,2,3],
 * ⁠ [4,5,6],
 * ⁠ [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 * ⁠ [7,4,1],
 * ⁠ [8,5,2],
 * ⁠ [9,6,3]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Given input matrix =
 * [
 * ⁠ [ 5, 1, 9,11],
 * ⁠ [ 2, 4, 8,10],
 * ⁠ [13, 3, 6, 7],
 * ⁠ [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 * ⁠ [15,13, 2, 5],
 * ⁠ [14, 3, 4, 1],
 * ⁠ [12, 6, 8, 9],
 * ⁠ [16, 7,10,11]
 * ]
 *
 *
 */
class Solution {
    // 算是规律题，方阵（N * N的矩阵）旋转90°
    // 就跟折一个方形纸片一样
    // 其实就是先将方阵沿着水平中心线交换一次（纸片上下对折）
    // 然后在沿着左上，右下的对角线再交换一次（纸片对角线对折）
    public void rotate(int[][] matrix) {
        // 边界
        if (matrix == null || matrix.length == 0) return;

        int i, j, k, temp;
        int n = matrix.length;

        // 上下对折
        for (i = 0; i < n; i++) {
            j = 0;
            k = n - 1;
            while (j < k) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
                j++;
                k--;
            }
        }

        // 对角线对折
        for (i = 0; i < n; i++) {
            for (k = 0; k < i; k++) {
                temp = matrix[i][k];
                matrix[i][k] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
    }
}

