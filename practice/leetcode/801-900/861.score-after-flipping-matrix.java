/**
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/submissions/
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/solution/fan-zhuan-ju-zhen-hou-de-de-fen-by-leetc-cxma/
 */
class Solution {
  public int matrixScore(int[][] A) {
    if (A == null || A.length == 0) return 0;

    int rows = A.length;
    int cols = A[0].length;
    boolean[] reverted = new boolean[rows];
    int sum = 0;

    for (int i = 0; i < rows; i++) {
      reverted[i] = (A[i][0] == 0);
      sum += (1 << (cols - 1));
    }

    for (int col = 1; col < cols; col++) {
      int cntOf1 = 0;
      for (int row = 0; row < rows; row++) {
        if ((reverted[row] && A[row][col] == 0) ||
            ((!reverted[row]) && A[row][col] == 1)) {
          cntOf1++;
        }
      }

      int cntOf0 = rows - cntOf1;
      int max = Math.max(cntOf1, cntOf0);
      sum += (max) * (1 << (cols - 1 - col));
    }

    return sum;
  }
}
