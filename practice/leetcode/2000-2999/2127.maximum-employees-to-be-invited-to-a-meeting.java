class Solution {
    public int maximumInvitations(int[] favorite) {
        // ans = Math.max(max(ringSize), sumChainSize)
        int maxRingSize = 0;
        int sumChainSize = 0;
        // 拓扑排序，找出环上点，同时构建反图用于找为2的反向链条
        int n = favorite.length;

        int[] degrees = new int[n];
        for (int e : favorite) {
            degrees[e]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) {
                q.offer(i);
            }
        }

        // 记录在环之外的点
        boolean[] visited = new boolean[n];
        // 记录反图
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            visited[x] = true; // 进队列的都视为被访问过
            int next = favorite[x];
            g[next].add(x);// 加入反图列表
            degrees[next]--;
            if (degrees[next] == 0) {
                q.offer(next);                
            }
        }

        // 遍历所有的点，对拓扑排序中在圈里面的点(visited[x]为false)找出其环的长度
        // 根据环的长度，进行分类判断
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 标记为true，避免重复访问这个环上的点
                visited[i] = true;
                int start = i;
                int next = favorite[start];
                int length = 1;
                while (next != start) {
                    visited[next] = true;
                    length++;
                    next = favorite[next];
                }

                if (length > 2) {
                    // 大于2的环，不能插入链子上的任何一个节点
                    maxRingSize = Math.max(maxRingSize, length);
                } else {
                    // 刚好为2的环，需要考虑两端出去的最长链子的长度
                    next = favorite[next];
                    int[] sides = new int[] { start, next };
                    sumChainSize += 2; // 把环长度加上
                    for (int side : sides) { // 环的两个端点
                        int currentLongestChainSize = cal(side, g, 0);
                        // 把环两端最长的链子长度加上
                        sumChainSize += currentLongestChainSize; 
                    }
                }
            }
        }

        return Math.max(maxRingSize, sumChainSize);
    }

    // 计算树的深度
    int cal(int start, List<Integer>[] g, int depth) {
        if (g[start].isEmpty()) {
            return depth;
        }

        int ans = 0;
        for (int branch : g[start]) {
            ans = Math.max(ans, cal(branch, g, depth + 1));
        }

        return ans;
    }
}
