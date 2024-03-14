class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long ans = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans = nums[i] <= ans ? ans + nums[i] : nums[i];
        }
        return ans;
    }
}
