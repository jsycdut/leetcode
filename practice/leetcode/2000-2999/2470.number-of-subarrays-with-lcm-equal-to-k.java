class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            long res = nums[i];
            for (int j = i; j < n; j++) {
                res = lcm(res, nums[j]);
                if (res == k)
                    cnt++;
                if (res > k)
                    break;
            }
        }
        return cnt;
    }

    long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }
}
