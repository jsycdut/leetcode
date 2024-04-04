class Solution {
    List<Integer>[] g;
    Map<Integer, Set<Integer>> map;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // 建图
        map = new HashMap<>();
        g = new List[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new TreeSet<>());
            set.add(i);
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (g[x] == null) {
                g[x] = new ArrayList<>();
            }
            g[x].add(y);
            set.remove(y);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i : set) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            Set<Integer> l = new HashSet<>();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                if (g[x] == null) {
                    // 已经是叶子结点了
                    continue;
                }
                for (int y : g[x]) {
                    // neighbors
                    map.get(y).addAll(map.get(x));
                    map.get(y).add(x);
                    l.add(y);
                }
            }

            for (int i : l) {
                q.offer(i);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> t = new ArrayList(map.get(i));

            ans.add(t);
        }

        return ans;
    }

}
