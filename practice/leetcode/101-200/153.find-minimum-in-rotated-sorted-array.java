/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] < nums[0]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo == nums.length ? nums[0] : nums[lo];
    }
}
