class Solution {
    public int minimumSum(int[] nums) {
        // 时间复杂度O(N)，但是空间复杂度O(n)
        int n = nums.length;
        int[] minL = new int[n];
        int[] minR = new int[n];
        minL[0] = nums[0];
        minR[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            minL[i] = Math.min(nums[i], minL[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            minR[i] = Math.min(nums[i], minR[i + 1]);
        }

        int ans = (int) 1e9;
        for (int i = 1; i < n - 1; i++) {
            if (minL[i - 1] < nums[i] && nums[i] > minR[i + 1]) {
                ans = Math.min(ans, minL[i - 1] + nums[i] + minR[i + 1]);
            }
        }

        return ans == (int)1e9 ? -1 : ans;
    }
}
