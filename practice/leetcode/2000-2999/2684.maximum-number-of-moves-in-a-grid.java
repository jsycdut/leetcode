class Solution {
    public int maxMoves(int[][] grid) {
        // dp[i][j] = max(dp[i][j+1], dp[i-1][j+1], dp[i+1][j+1]) + 1
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int j = n - 2; j >= 0; j--) {// 由于依赖j+1列，必须先循环列
            for (  int i = m - 1; i >= 0; i--) {// 其次是循环行
                if (grid[i][j] < grid[i][j + 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
                if (i + 1 < m && grid[i][j] < grid[i + 1][j + 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1] + 1);
                if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j + 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }
}
