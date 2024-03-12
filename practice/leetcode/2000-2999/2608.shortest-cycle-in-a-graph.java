class Solution {
    List<Integer>[] g;
    int[] dis;
    int ans = (int) 1e9;

    public int findShortestCycle(int n, int[][] edges) {
        g = new List[n];
        dis = new int[n];
        Arrays.setAll(g, ArrayList::new);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        for (int i = 0; i < n; i++) bfs(i);
        return ans == (int)1e9 ? -1 : ans;
    }

    void bfs(int start) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[g.length];
        while (!q.isEmpty()) {
            int x = q.poll();
            visited[x] = true;
            for (int y : g[x]) {// 邻居
                if (visited[y]) continue;
                if (dis[y] == Integer.MAX_VALUE) {
                    dis[y] = dis[x] + 1;
                    q.offer(y);
                } else {
                    ans = Math.min(ans, dis[y] + dis[x] + 1);
                }
            }
        }
    }

