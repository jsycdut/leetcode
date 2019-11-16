/*
 * @lc app=leetcode id=1071 lang=java
 *
 * [1071] Greatest Common Divisor of Strings
 *
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
 *
 * algorithms
 * Easy (53.92%)
 * Total Accepted:    13.5K
 * Total Submissions: 25K
 * Testcase Example:  '"ABCABC"\n"ABC"'
 *
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T
 * concatenated with itself 1 or more times)
 * 
 * Return the largest string X such that X divides str1 and X divides str2.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] and str2[i] are English uppercase letters.
 * 
 * 
 */
class Solution {
    // 求两个字符串的最大公约字符串，其实这个是典型的gcd，也就是辗转相除法
    // 类比求两个数的最大公约数是将两个数不断相减而其中一个最终为0得到最大公约数
    // 这个字符串也是类似，主要利用字符串的一些api，比如判断字符串是否以某个字符串开头
    // 和截取子串的方法，另外注意一下边界判断就可以了。
    // 题解：https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/303781/JavaPython-3-3-codes-each%3A-Recursive-iterative-and-regex-w-brief-comments-and-analysis.
    public String gcdOfStrings(String str1, String str2) {
      if (str1 == null || str2 == null) return "";

      if (str1.length() < str2.length()) return gcdOfStrings(str2, str1);

      if (!str1.startsWith(str2)) return "";

      if (str2.length() == 0) return str1;

      return gcdOfStrings(str1.substring(str2.length()), str2);
    }
}

