class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] mask = new int[m];
        // 当行代表的数值
        for (int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                mask[i] += matrix[i][j] << (n - j -1);
            }
        }

        // 枚举所有可能的操作
        int max = 1 << n;
        int cur = 0;
        int ans = 0;
        while (cur <= max) {
            if(Integer.bitCount(cur) != numSelect) {
                cur++;
                continue;
            }

            int cnt = 0;
            for (int i : mask) {
                if ((i & cur) == i) cnt++;
            }
            ans = Math.max(ans, cnt);
            cur++;
        }

        return ans;
    }
}
