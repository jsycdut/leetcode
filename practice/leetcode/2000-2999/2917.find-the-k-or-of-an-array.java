class Solution {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (((num & (1 << i))) == (1 << i)) cnt++;
            }

            if (cnt >= k) ans = ans | (1 << i);
        }

        return ans;
    }
}
