/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.24%)
 * Total Accepted:    262K
 * Total Submissions: 812.7K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 *
 *
 */
class Solution {
    public int lengthOfLastWord(String s) {
        // 没什么营养的题, 做法非常多
        // 找到最后一个空格的索引就可以解
        // 需要注意的值就是空格在最后的情况, 用trim去掉这种情况即可
        if (s == null || s.length() == 0) return 0;

        s = s.trim();
        return s.length() - (s.lastIndexOf(" ") + 1);
    }
}

