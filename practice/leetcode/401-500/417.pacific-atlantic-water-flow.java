class Solution {
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int[][] heights;
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // 这个dfs如果要入海洋，则需要回溯，而且回溯的时候要分情况讨论，是从大西洋回来还是从太平洋回来
        // 逻辑上似乎要分成两个dfs来写，我的头都大了
        // 采取题解的方式吧，从海里回流
        // 第一行 pacific
        for (int i = 0; i < n; i++) {
            dfs(0, i, pacific);
        }
        // 第一列
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }

        // 最后一行
        for (int i = 0; i < n; i++) {
            dfs(m - 1, i, atlantic);
        }

        // 最后一列
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    list.add(Arrays.asList(i, j));
                }
            }
        }

        return list;

    }

    void dfs(int x, int y, boolean[][] ocean) {
        if (ocean[x][y]) {
            return;
        }

        ocean[x][y] = true;
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (0 <= newX && newX < m && 0 <= newY && newY < n && heights[newX][newY] >= heights[x][y]) {
                dfs(newX, newY, ocean);
            }
        }
    }
}
