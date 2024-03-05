class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 最短路，dijkstra模板题
        List<int[]>[] g = new List[n+1];
        Arrays.setAll(g, ArrayList::new);
        for (int[] edge : times) {
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            g[x].add(new int[]{y, w});
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e7);
        distance[k] = 0; // 起始点是k
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});// 距离， id
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            int dis = a[0];
            int x = a[1];
            visited[x] = true;
            if (dis > distance[x]) continue; // 被多次松弛的点

            // 松弛
            for (int[] arr : g[x]) {
                int y = arr[0];
                int w = arr[1];
                if (dis + w < distance[y]) {
                    distance[y] = dis + w;
                    pq.offer(new int[]{distance[y], y});
                }
            }
        }

        // 有"点"没有被松弛到，说明不可达
        for (int i = 1 ;i <= n; i++) {
            if (!visited[i]) {
                return -1;
            }
        }

        // 1, n 中最短路中的最大值，索引0不参与计算
        distance[0] = -1;
        return Arrays.stream(distance).max().getAsInt();

    }
}
