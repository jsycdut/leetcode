/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (33.44%)
 * Total Accepted:    293.3K
 * Total Submissions: 877.2K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};

        // 又是一个二分查找的题，只不过这里查找的是存在重复元素的情况
        // 找到重复元素的第一个和最后一个

        // 如果要查找的值找不到
        // first为nums.length或者为大于target的第一个值
        // last为-1或者为小于target的第一个值
        // 回去要再看看算法里面的二分了
        // 自从看了那本挑战程序设计竞赛里面的二分之后，我的二分都是用上下界的写法
        // 很少用教科书里面的写法了，回去对照着《算法》（第四版）和《挑战程序设计竞赛》
        // 再学习一下二分
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        int[] ans = {-1, -1};
        if (first != nums.length && nums[first] == target) ans[0] = first;
        if (last != -1 && nums[last] == target) ans[1] = last;

        return ans;
    }

    int findFirst(int[] arr, int target) {
        int lb = -1;
        int ub = arr.length;

        while (ub - lb > 1) {
            int mid = (lb + ub) >>> 1;
            if (arr[mid] >= target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return ub;
    }

    int findLast(int[] arr, int target) {
        int lb = -1;
        int ub = arr.length;

        while (ub - lb > 1) {
            int mid = (lb + ub) >>> 1;
            if (arr[mid] <= target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb;
    }
}

