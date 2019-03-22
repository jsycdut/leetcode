/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (31.39%)
 * Total Accepted:    394.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 *
 * Example 1:
 *
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 *
 */
class Solution {
    // Sorry, I cheat...
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) return 0;

        // 前方处理掉特殊的测例，后面直接调java.lang.String的方法就可解此题
        // 但明显这不是题目考察的本意，面试的话这一招肯定是要被禁用的
        // 所以下一个解答我还是自己实现算法吧（逃
        return haystack.indexOf(needle);
    }
}

