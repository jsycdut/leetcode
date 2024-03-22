class Solution {
    public int jump(int[] nums) {
        // min(dp[i] + 1) 0 <=i < n - 1
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE / 4);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                int nextIdx = i + j;
                if (nextIdx < n) {
                    dp[nextIdx] = Math.min(dp[nextIdx], dp[i] + 1);
                }
            }

        }

        return dp[n - 1];
    }
}
