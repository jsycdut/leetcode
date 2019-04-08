/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (40.49%)
 * Total Accepted:    380K
 * Total Submissions: 935.5K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [1,3,5,6], 0
 * Output: 0
 * 
 * 
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        // 边界条件
        if (nums == null || nums.length == 0) return 0;

        return binarySearch(nums, target);

    }

    // 由于二分的特点就是会去找最靠近目标值的那个索引
    // 不管找不找得到，最后肯定是停在最靠近目标的附近
    // 所以如果最后的结果值等于目标，那么刚刚好
    // 如果大了，那么说明前面的值肯定是小于目标值的
    // 现在的位置就是应该插入的位置
    // 如果小了，那么说明之后的值大于目标值
    // 目标值就可以刚刚好放到那里去
    //
    // 其实需要理解到的就是二分查找最后会在搜寻范围只剩一个数的时候停下来
    // 这个数一定是最靠近目标查找的值
    // 根据这个索引上的值和搜寻目标的关系，就可以解出此题
    //
    int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            // 这种骚操作是从jdk 1.8 Collections.java里面的二分查找里面学的
            mid =  (hi + lo) >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                break;
            }
        }
        return nums[mid] >= target ? mid : mid + 1;
    }
}

