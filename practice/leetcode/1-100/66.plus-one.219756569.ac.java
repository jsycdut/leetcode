/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (40.90%)
 * Total Accepted:    368.9K
 * Total Submissions: 902K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 *
 * Example 1:
 *
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 *
 * Example 2:
 *
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 */
class Solution {
    // 思路很简单，在digits最后一位加1
    // 然后逐步向前处理可能的进位即可
    // 但是需要注意数组全部成员都是9的情况
    // 这会导致结果数组的长度和digits长度不一致
    // 需要额外考虑
    public int[] plusOne(int[] digits) {
        // 边界条件，为空，长度为0
        if (digits == null || digits.length == 0) return new int[0];

        // 应对{9, 9, 9...}这种情况，这样会引起全部进位
        // 从而导致结果数组的长度为digits长度加1，需要特殊应对
        boolean unicorn = true;
        for (int i : digits) {
            if (i != 9) {
                unicorn = false;
                break;
            }
        }

        if (unicorn) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;

            for (int i = 1; i < res.length; i++) {
                res[i] = 0;
            }

            return res;
        }

        // 处理不会引起数组长度变化的普通情况
        // 也可以用递归来写，不过不想多写函数，直接迭代也可以解决
        int i = digits.length - 1;
        int carrier = 1;
        while (i >= 0 && carrier == 1) {
            int sum = digits[i] + 1;
            digits[i] = sum % 10;
            if (sum < 10) carrier = 0;
            i--;
        }

        return digits;
    }
}

