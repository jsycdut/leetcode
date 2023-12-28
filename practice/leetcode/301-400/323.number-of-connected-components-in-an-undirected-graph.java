class Solution {
    List<Integer>[] g;
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        g = new ArrayList[n];
        for(int i = 0; i<n;i++){
            g[i] = new ArrayList<>();
        }
        visited=new boolean[n];
        // 建图
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int idx = 0;
        int cnt = 0;
        while (idx < n) {
            if (!visited[idx]){
                cnt++;
                dfs(idx);
            }
            idx++;
        }

        return cnt;
    }

    void dfs(int x){
        if (visited[x]) return;
        visited[x] = true;
        for(int i : g[x]) {
            dfs(i);
        }
    }
}
