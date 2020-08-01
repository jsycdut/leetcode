/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        int first = nums[0];
        int last = nums[hi];
        
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (first <= nums[mid]) { // 目前定位在mid左边一段有序
                 if (nums[mid] > target && target >= first) {
                     hi = mid - 1;
                 } else {
                     lo = mid + 1;
                 }
            } else { // mid 右边一段有序
                if (nums[mid] < target && target <= last) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
