class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int n = changed.length;
        int[] ans = new int[n / 2];
        int idx = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = changed[i];
                if (cnt.get(val) == null){
                    // 超标了
                    if (idx == n / 2){
                        return new int[0];
                    }
                    ans[idx++] = val;
                    // 标记某个2倍的值
                    cnt.put(val * 2, cnt.getOrDefault(val * 2, 0) + 1);
                } else {
                    // 当前是某个倍标记的2倍值，需要消去
                    int count = cnt.get(val);
                    if (count > 1) {
                        cnt.put(val, count - 1);
                    } else {
                        cnt.remove(val);
                    }
                }
        }

        return ans;
    }
}
