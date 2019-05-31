/*
 * @lc app=leetcode id=557 lang=java
 *
 * [557] Reverse Words in a String III
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (63.91%)
 * Total Accepted:    123K
 * Total Submissions: 192.5K
 * Testcase Example:  `"Let's take LeetCode contest"`
 *
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * 
 * 
 * Note:
 * In the string, each word is separated by single space and there will not be
 * any extra space in the string.
 * 
 */
class Solution {
    public String reverseWords(String s) {
      // 解法I：快慢指针
      // 快慢指针可以解决此题
      // begin代表单词的开头
      // end代表单词结尾的空格
      // 当end为空格，begin不是空格，就reverse一次
      // 但是等到最后，若字符串的最后一个字符不是空格
      // 比如"hello world"这种，就需要特殊对待，也需要reverse
      // 否则会漏掉最后一个单词没有reverse的情况
      
      if (s == null || s.length() == 0) return "";
      
      char[] arr = s.toCharArray();
      
      int begin = 0;
      int end = 0;
      
      while (end <= arr.length) {
        if (arr[begin] == ' ') begin++;
      
        if ((end == arr.length|| arr[end] == ' ') && arr[begin] != ' ') {
          reverse(arr, begin, end - 1);
          begin = end;
        }
        end++;
      }
      
      return new String(arr);
    }

    void reverse(char[] arr, int begin, int end) {
      while (begin < end) {
        char temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
        begin++;
        end--;
      }
    }
}

