/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.30%)
 * Total Accepted:    307.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore
 * it matches "aab".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
      // 如果有null，那么匹配肯定不成功
      if (s == null || p == null) return false;
 
      // 本题很难，考察的是动态规划
      // dp[i][j]代表s的1~i个位置所形成的字符串
      // 和p的1~j个位置所形成的字符串是否匹配
      // 注意i和j都是从1开始，因为要给空字符串留个位置表示
      // dp[0][0]代表s和p长度都是0，也就是都是空字符串，此时是匹配的
      // dp[0][j]代表目前匹配的s的那部分是空字符串，此时只有a*b*c*这样的p才能与之匹配
      // 这也是下面第一个for循环从2开始的原因，一来匹配的就是位置2上的*
      // dp[i][0]想都不用想，肯定是false，因为p为空而s不为空，因为Java的布尔数组的默认值
      // 所以不必为这种情况赋值，自动就是false了
      //
      // 处理完空串的情况后，就可以正式进入后面的匹配了
      // dp[i][j]，各自对应的字符串末尾的字符是s.charAt(i - 1) 和 p.charAt(j - 1)
      // 如果这两个字符是匹配的，也就是s.charAt(i - 1) == p.charAt(j - 1)或者p.charAt(j - 1) == '.'
      // 此时dp[i][j]的匹配程度是和dp[i - 1][j - 1]一致的
      // 除了匹配之外的情况是，p.charAt(j - 1)为普通字符且和s.charAt(i - 1)不一致
      // 以及p.charAt(j - 1)为*，不一致的话就是dp[i][j]的默认值false
      // 为*的话，由于*是和*前面的字符相关的，所以需要考察*前面的字符也就是p.charAt(j - 2)和
      // s.charAt(j - 1)是否一致，如果不一致，那么只能考虑把p.charAt(j - 2)匹配0次，此时dp[i][j] = dp[i][j - 2]
      // 如果一致，就要考虑把p.charAt(j - 2) 匹配0次，1次，n次的情况
      // 分别是
      // dp[i][j] = dp[i][j - 2] 
      // dp[i][j] = dp[i][j - 1]
      // dp[i][j] = d[i - 1][j]
      //
      // 匹配n次是最不好理解的，试想
      //
      //     5
      // abbbbb
      //   3
      // ab*
      //
      // 一个*能匹配某个字符n次，说明前面n-1次也必定是被*匹配了的，此时dp[i][j] = dp[i - 1][j]
      //
      // 最后的匹配结果就是dp[s.length()][p.length()]
      //
      boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

      dp[0][0] = true;

      for (int j = 2; j <= p.length(); j++) {
        if (p.charAt(j - 1) ==  '*' && dp[0][j - 2]) dp[0][j] = true;
      }

      for (int i = 1; i <= s.length(); i++) {
        for (int j = 1; j <= p.length(); j++) {
          if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
            dp[i][j] = dp[i - 1][j - 1];
          } else if (p.charAt(j - 1) == '*') {
            if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
              dp[i][j] = dp[i][j - 2];
            } else {
              dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
            }
          }
        }
      }

      return dp[s.length()][p.length()];
    }
}

