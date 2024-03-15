class Graph {
    int[][] dp;// 最短路

    public Graph(int n, int[][] edges) {
        // 建图
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 4);
            dp[i][i]= 0;
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int z = edge[2];
            dp[x][y] = z;
        }

        // 开始弗洛伊德 dp[i][j]= min(dp[i][j], dp[i][k] + dp[k][j]);
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
    }

    public void addEdge(int[] edge) {
        int x = edge[0];
        int y = edge[1];
        int z = edge[2];
        // 加入的边更长，不会改变最短路
        if (dp[x][y] < z) {
            return;
        }

        int n = dp.length;
        // 暴力更新可能的最短路
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (z < dp[i][j]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][x] + z + dp[y][j]);
                }
            }
        }
    }

    public int shortestPath(int node1, int node2) {
        return dp[node1][node2] == Integer.MAX_VALUE / 4 ? -1 : dp[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
