/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (39.85%)
 * Total Accepted:    541.8K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 *
 *
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means
 * modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len
 * elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 *
 */
class Solution {
    // 此解法后发制人，先将数组里面重复的置为Integer.MAX_VALUE
    // 然后从头开始遍历，遇见Integer.MAX_VALUE就和后面第一个不是Integer.MAX_VALUE的数交换
    // 这样将大大减少了交换次数
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;

        // 置Integer.MAX_VALUE
        for (int i = 0; i < len; ) {
            int j = 1;
            while (i + j < len && nums[i + j] == nums[i]) {
                nums[i + j] = Integer.MAX_VALUE;
                j++;
            }

            i += j;
        }

        // 替换Integer.MAX_VALUE
        for (int i = 0; i < len; i++) {
           if (nums[i] == Integer.MAX_VALUE) {
               for (int j = i + 1; j < len; j++) {
                   if (nums[j] != Integer.MAX_VALUE) {
                       nums[i] = nums[j];
                       nums[j] = Integer.MAX_VALUE;
                       break;
                   }
               }
           }
        }

        int res;
        for (res = 0; res < len; res++) {
            if (nums[res] == Integer.MAX_VALUE) break;
        }

        return res;
    }
}

