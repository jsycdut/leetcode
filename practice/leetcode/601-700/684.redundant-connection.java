class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // 裸题，树: |V| - 1 = |E|，任意加个边， |V| = |E|
        // 不断合并边上的两个顶点，如果发现要合并的这两个顶点属于一个并查集，那么环就产生了
        // 如何确定题目里所说的出现最靠后的那条边？
        // 按照顺序枚举edges，如果他导致成环，就是他了，因为就差他一条边就成环，他肯定是所说的最后一条边
        // 有点乱啊。。。
        int n = edges.length;
        int[] p = new int[n + 1];
        for (int i = 0; i <= n; i++)
            p[i] = i;
        int[] size = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (union(p, size, edge[0], edge[1]) == 0) {
                return edge;
            }
        }

        return new int[0];
    }

    int find(int[] p, int x) {
        if (x == p[x]) {
            return x;
        }

        return p[x] = find(p, p[x]);
    }

    int union(int[] p, int[] size, int x, int y) {
        x = find(p, x);
        y = find(p, y);
        if (x == y) {
            return 0;
        }

        if (size[x] >= size[y]) {
            size[x] += size[y];
            p[y] = x;
        } else {
            size[y] += size[x];
            p[x] = y;
        }
        return 1;
    }
}
