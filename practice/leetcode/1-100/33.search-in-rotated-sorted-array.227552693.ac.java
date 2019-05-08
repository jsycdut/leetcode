/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.85%)
 * Total Accepted:    404.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */
class Solution {
    public int search(int[] nums, int target) {
        // 思路：先用二分，找出分段点
        // 然后判断target在前面一段还是后面一段，再二分搜索
        if (nums == null || nums.length == 0) return -1;

        // 二分查找分段点，上界就是分段点
        // 这里的二分并不是那种应用于已经排好序的单调递增数组
        // 此处的数组是折断的，不是单调递增的，但是二分的思想仍然可以用
        int pointer = nums[0];
        int lb = -1;
        int ub = nums.length;

        while (ub - lb > 1) {
            int mid = (lb + ub) >>> 1;

            if (nums[mid] >= pointer) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        // 原数组没有分段，比如测例'[3]\n3'
        if (ub == nums.length) return binarySearch(nums, 0, nums.length - 1, target);

        // 分段二分搜索查找值
        if (target >= pointer) {
            return binarySearch(nums, 0, ub - 1, target);
        } else {
            return binarySearch(nums, ub, nums.length - 1, target);
        }
    }

    // 对有序的数组使用二分
    int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) >>> 1;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

