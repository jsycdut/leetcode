class Solution {
    public int countComponents(int n, int[][] edges) {
        // 干他并查集
        int[] p = new int[n + 1];
        // 并查集的表示，所有节点的爹都是他自己，表示全部散兵游泳当混子
        for (int i = 0; i <= n; i++)
            p[i] = i;

        // 表示每个联通分量下面小弟的数量
        int[] size = new int[n + 1];
        Arrays.fill(size, 1);

        for (int[] edge : edges) {
            n -= union(p, size, edge[0], edge[1]);
        }

        return n;
    }

    int find(int[] parents, int x) {
        if (x == parents[x]) {
            return x;
        }

        // 顺带把路径压缩做了
        return parents[x] = find(parents, parents[x]);
    }

    // x, y已经是根了
    int union(int[] parents, int[] size, int x, int y) {
        x = find(parents, x);
        y = find(parents, y);
        if (x == y) {
            return 0;
        }
        // 启发式合并，就是数据量少的去投靠数据量大的
        if (size[x] > size[y]) {
            size[x] += size[y];
            parents[y] = x;
        } else {
            size[y] += size[x];
            parents[x] = y;
        }
        return 1;
    }


}
