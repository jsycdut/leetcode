class Graph {
    List<int[]>[] g; // 一个成员为数组的列表所组成的数组

    public Graph(int n, int[][] edges) {
        // 建图
        g = new List[n];
        Arrays.setAll(g, ArrayList::new);
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        int x = edge[0];
        int y = edge[1];
        int w = edge[2];
        g[x].add(new int[] { y, w }); // 目标节点坐标，权重
    }

    public int shortestPath(int node1, int node2) {
        // 有请著名图论大师，迪杰斯特拉闪亮登场
        // 1. 距离数组
        int[] distance = new int[g.length];
        Arrays.fill(distance, (int) 1e7);
        distance[node1] = 0;
        // 这次不写visited数组了
        // 2. 优先队列优化
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, node1 }); // 距离，节点id
        while (!pq.isEmpty()) {
            int[] shortest = pq.poll();
            int dis = shortest[0];
            int x = shortest[1];
            if (dis > distance[x])
                continue;// 多次被松弛到的点

            // 松弛队友
            for (int[] next : g[x]) {
                int y = next[0];
                int w = next[1];
                // 成功松弛
                if (dis + w < distance[y]) {
                    distance[y] = dis + w;
                    pq.offer(new int[] { distance[y], y });
                }
            }

        }

        // 要考虑不可达的情况，此时目标点它的距离没有被更新，是我设置的初始值1e7;
        return distance[node2] == (int) 1e7 ? -1 : distance[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
