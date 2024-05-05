class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    ans[i] += code[(i + j + 1) % n];
                }
            }
        }

        if (k < 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j > k; j--) {
                    ans[i] += code[(i + j + n - 1) % n];
                }
            }
        }

        return ans;
    }
}
