class Solution {
    public int minimumPossibleSum(int n, int target) {
        int mod = (int)1e9 + 7;
        int m = target / 2;
        return n <= m ? (int)(sum(1, n) % mod)
                      : (int)((sum(1, m) % mod + sum(target, target + (n - m) - 1) % mod) % mod);
    }

    public long sum(long a, long b) {
        // 等差数组求和公式
       return (a + b) * (b - a + 1) / 2;
    }
}
