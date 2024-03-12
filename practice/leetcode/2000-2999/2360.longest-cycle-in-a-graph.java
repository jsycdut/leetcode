class Solution {
    public int longestCycle(int[] edges) {
        // 拓扑排序, 找出环，然后环上bfs求大小
        int n = edges.length;
        int[] degrees = new int[n];
        // 预处理有入边的顶点的入度，最终入度为0的，就是拓扑排序的起点顶点
        for (int vertex : edges) {
            if (vertex != -1) {
                degrees[vertex]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int vertex = 0; vertex < n; vertex++) {
            if (degrees[vertex] == 0) { // 入度为0的，加入到队列中用来做拓扑排序
                q.offer(vertex);
            }
        }
        
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int vertex = q.poll();
            // 出现在队列中的顶点，都视为被访问过的“不会对答案造成影响的”
            visited[vertex] = true;
            int next = edges[vertex];
            if (next != -1) {
                // 出边对应的入度减1
                degrees[next]--;
                if (degrees[next] == 0) {
                    q.offer(next); // 入度为0了
                }
            }
        }

        // 至此，所有不在环上的点，对应的入度都是0
        int ans = -1;
        for (int i = 0; i < n; i++) {
            // 访问过的，包含“不在环上顶点” + “环已经被遍历过，这个环上的其他节点没必要继续访问"
            if (visited[i]) {
                continue;
            }

            int idx = i, length = 1;
            while (i != edges[idx]) { // 遍历一圈回来就是起点
                visited[idx] = true;
                idx = edges[idx];                
                length++;
            }

            ans = Math.max(ans, length);
        }
        return ans;
    }
}
