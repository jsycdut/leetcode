class Solution {
    public long minCost(int[] nums, int x) {
        // 操作k次 cost[i] = nums[(i+k) % n]
        // dp数组，记录k次操作后取得该类型的最小值
        // dp[k][i] = min{dp[k][i-1], nums[(k+i) % n]}
        // ans = min(ans, sum(dp[i][k]) + k*x)
        long[][] dp = new long[nums.length][nums.length];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = nums[i];
        }

        long ans = 0;
        for (long i : dp[0]) {
            ans += i;
        }

        for (int k = 1; k < nums.length; k++) {
            long t = 0;
            for (int i = 0; i < nums.length; i++) {
                dp[k][i] = Math.min(dp[k - 1][i], nums[(i + k) % nums.length]);
                t += dp[k][i];
            }
            ans = Math.min(ans, t + (long) x * (long) k);
        }

        return ans;
    }
}
