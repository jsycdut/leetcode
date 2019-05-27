/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (30.56%)
 * Total Accepted:    335.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 *
 * Example 1:
 *
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: "race a car"
 * Output: false
 *
 *
 */
class Solution {

    // 老套路，仍旧是双指针
    // 不过需要注意的就是工具类的使用，Character类的toLowerCase将大写字母转换为小写字母
    // 以及isLetterOrDigit判断字符是否为大小写字母和数字，当然也可以自己单独写一个检查是否为大小写字母和数字的方法
    // 比如下面的check方法
    public boolean isPalindrome(String s) {
        // 边界
        if (s == null || s.length() == 0) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!check(s.charAt(left))) {
              left++;
            } else if (!check(s.charAt(right))) {
              right--;
            } else if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
              left++;
              right--;
            } else {
              return false;
            }
        }

        return true;
    }
  
    // 检查大小写字母或者数字
    boolean check(char c) {
      return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9');
    }
}

