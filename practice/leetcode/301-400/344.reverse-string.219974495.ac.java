/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (63.00%)
 * Total Accepted:    397K
 * Total Submissions: 630.1K
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii
 * characters.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 *
 *
 * Example 2:
 *
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 *
 *
 */
class Solution {
    // 没难度，双指针搞定
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        int left = 0;
        int right = s.length - 1;
        char temp;

        while (left < right) {
            temp = s[right];
            s[right] = s[left];
            s[left] = temp;

            right--;
            left++;
        }
    }
}

