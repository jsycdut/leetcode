class Solution {
    // 其实是个二分，把数组拉成一维的就是很明显的题目
    // 在二维里面，其实只要按照二分思路走，然后将mid的值落到二维矩阵中就好了
    public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0) return false;

      int segments = matrix.length;
      int segmentsSize = matrix[0].length;
      int lo = 0;
      int hi = segments * segmentsSize - 1;

      while (lo <= hi) {
        int mid = (lo + hi ) >>> 1;
        int row = mid / segmentsSize;
        int col = mid % segmentsSize;

        if (matrix[row][col] > target) {
          hi--;
        } else if (matrix[row][col] < target) {
          lo++;
        } else {
          return true;
        }
      }

      return false;
    }
}
