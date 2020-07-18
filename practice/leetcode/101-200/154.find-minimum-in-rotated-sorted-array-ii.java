/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        int last = nums[hi];

        while (lo < nums.length && nums[lo] == last) lo++;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] <= last) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return nums[hi];
    }
}
