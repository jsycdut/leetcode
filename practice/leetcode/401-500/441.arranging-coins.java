class Solution {
    public int arrangeCoins(int n) {
      int l = 1, r = n;
      int ans = 1;
      while (l <= r) {
        int mid = (l + r) >>> 1;
        if ((long)mid * (mid + 1) <= (long)2 * n) {
          ans = mid;
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }

      return ans;
    }
}
