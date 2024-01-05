class Solution {
    public int coinChange(int[] arr, int x) {
        int[] mem = new int[x + 1];
        int ans = dfs(arr, x, mem);
        return ans;
    }

    int dfs(int[] arr, int x, int[] mem) {
        // 凑不到
        if (x < 0) {
            return -1;
        }

        // 刚好凑到
        if (x == 0) {
            return 0;
        }

        // 之前已经凑到过了，直接返回记录
        if (mem[x] != 0) {
            return mem[x];
        }

        int min = Integer.MAX_VALUE;
        // 试探每一种可能的来源，在其基础上加一枚，取所有可能的最小值
        for (int i : arr) {
            int t = dfs(arr, x - i, mem);
            if (t >= 0 && t < min) {
                min = t + 1;
            }
        }
        // 怎么也凑不到
        if (min == Integer.MAX_VALUE) {
            // 凑不到也要记录下来，要不然下一个递归还是会执行过来，叶子节点数量庞大导致时间过长
            mem[x] = -1;
            return -1;
        } else {
            mem[x] = min;
            return mem[x];
        }
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
