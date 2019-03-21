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
    // 绝对的最佳算法，一遍O(N)过
    // 采用双指针的办法，i从0开始，代表不重复数字中的最后一个，j从1开始，作为探测指针，不断地与i的值比较
    // 如果相同，那么可以跳过，不同的话，就找到了下一个不重复的值，此时i+1，然后赋予此时j的值，然后如此往复
    // 最后返回i+1就行了
    // 这办法比我的前两个解都妙的多，果然不愧是高手的解法，
    // 这个算法妙就妙在，在一波循环里面，既找到了重复的值，又找到了当重复的值过去之后，不重复的值该存放的位置
    // 太妙了，此刻该有 橘猫的妙啊 表情包的（逃

    public int removeDuplicates(int[] nums) {
        // 边界判断
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int i = 0, j;

        for (j = 1; j < len; j++) {

            // 发现不重复的值
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }

            // 默认再重复的时候只需要探测指针j++即可
        }

        return i + 1;
    }
}

