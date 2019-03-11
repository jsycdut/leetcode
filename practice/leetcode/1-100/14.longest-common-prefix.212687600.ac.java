/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.01%)
 * Total Accepted:    413.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 *
 * Example 2:
 *
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 */
class Solution {
    // 暴力解法，从左到右一个一个的比较
    public String longestCommonPrefix(String[] strs) {
        // 边界条件，判空，判只有一个元素
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        // 只需要按照数组中所有字符串中最短的长度来遍历就行了
        int limit = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            limit = Math.min(strs[i].length(), limit);
        }

        StringBuilder sb = new StringBuilder();
        char c;
        int j, k;

        // 外层循环遍历str[0]，内层则判断数组其他元素对应位置的字符是否与之契合
        for (j = 0; j < limit; j++) {
            c = strs[0].charAt(j);
            for (k = 1; k < strs.length; k++) {
                if (strs[k].charAt(j) != c) break;
            }

            if (k == strs.length) {
                sb.append(c);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}

