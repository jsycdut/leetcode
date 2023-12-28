class Solution {
    public int findCircleNum(int[][] m) {
        // 连通分类数量问题，输入是一个邻接矩阵
        int n = m.length;
        boolean[] visited = new boolean[n];
        int idx = 0;
        int cnt = 0;
        while(idx < n) {
            if (!visited[idx]) {
                dfs(idx, m, visited);
                cnt++;
            }
            idx++;
        }

        return cnt;

    }

    void dfs(int x, int[][]m, boolean[] visited) {
        if (visited[x]) return;
        visited[x] = true;

        for (int i = 0; i < m.length; i++) {
            if (i == x)continue;
            if (m[x][i] == 1) dfs(i, m, visited);
        }
    }
}
