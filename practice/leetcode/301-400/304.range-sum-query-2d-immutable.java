/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/submissions/
 */
class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        sum = new int[rows][cols];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < cols; i++) {
            sum[0][i] = sum[0][i - 1] + matrix[0][i];
        }
        
        for (int j = 1; j < rows; j++) {
            sum[j][0] = sum[j - 1][0] + matrix[j][0];
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) return sum[row2][col2];
        if (row1 == 0) {
          return sum[row2][col2] - sum[row2][col1 - 1];
        } else if (col1 == 0) {
          return sum[row2][col2] - sum[row1 - 1][col2];
        }
        return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

