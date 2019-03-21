/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 *
 * https://leetcode.com/problems/remove-element/description/
 *
 * algorithms
 * Easy (43.77%)
 * Total Accepted:    381.8K
 * Total Submissions: 871.4K
 * Testcase Example:  '[3,2,2,3]\n3'
 *
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 *
 * Example 1:
 *
 *
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 *
 * Example 2:
 *
 *
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * Your function should return length = 5, with the first five elements of nums
 * containing 0, 1, 3, 0, and 4.
 *
 * Note that the order of those five elements can be arbitrary.
 *
 * It doesn't matter what values are set beyond the returned length.
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
 * int len = removeElement(nums, val);
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
    // 基本思路就是双指针，一个指针i前往后遍历，用于探测目标值
    // 一个指针j从后往前，目的是找到不是目标的任意其他值
    // 这样在i找到目标的时候，用j的那个不是目标的值将其替换
    // 这样就等价于完成了对目标值的删除（题目说了顺序不重要，所以可以这么干）
    // 但是有些狗血的特殊情况要考虑，比如数组里全是目标值, nums = {1, 1, 1, 1},val = 1
    // 但是这种情况的话会造成i和j重合且都等于0，所以可以判断
    // 还有一种，就是仍然会造成i和j重合且都等于0的情况，如nums = {1}, val = 2
    // 这个时候就只能再骚一把，再判断一下了，╮(╯▽╰ )╭真是令人害怕啊，一个easy级别的题竟然踩了四次雷，花了5次才AC，哭唧唧。。。
    // 还好击败了100%的Java提交，╮(╯▽╰ )╭只能这么自我安慰了
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int i = 0;
        int j = len - 1;

        // 先来一遍，从后往前找到第一个非目标的值
        while (0 < j && nums[j] == val) j--;

        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            }

            // 每找到一个目标值，完成替换，就得找新的不是目标的值了
            while (0 < j && nums[j] == val) j--;
            i++;
        }

        // 判断真骚啊
        return (i == j && i == 0 && nums[i] == val) ? 0 : j + 1;
    }
}

