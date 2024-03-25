class Solution {
    public int longestConsecutive(int[] nums) {
        // 精华，nums的负数转换为对应的索引，值相邻，就把值对应索引加到一个联通块里面
        int n = nums.length;
        int[] p = new int[n];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            p[i] = i;
            m.put(nums[i], i);
        }
        int[] size = new int[n];
        Arrays.fill(size, 1);
        for (int i : m.keySet()) {
            int idx = m.get(i);
            if (m.containsKey(i - 1)) {
                int neighborIdx = m.get(i - 1);
                union(p, size, idx, neighborIdx);
            }
            if (m.containsKey(i + 1)) {
                int neighborIdx = m.get(i + 1);
                union(p, size, idx, neighborIdx);
            }
        }

        int max = 0;
        for (int i : size)
            max = Math.max(max, i);
        return max;
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

        if (size[x] <= size[y]) {
            size[y] += size[x];
            p[x] = y;
        } else {
            size[x] += size[y];
            p[y] = x;
        }

        return 1;
    }
}
