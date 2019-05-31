/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (43.63%)
 * Total Accepted:    95K
 * Total Submissions: 217.8K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
      // 边界条件，面试的时候一定要问字符串为null或者长度为0怎么处理
      if (num1 == null || num1.length() == 0) return num2;
      if (num2 == null || num2.length() == 0) return num1;

      // 常规思路，m，n保存字符串访问的索引，从后往前
      // 用字符数组保存计算结果，其长度len 为两个字符串长度较长的那个再加1
      // 这个1是为了可能的最后的进位准备的
      // 这里的m != -1 || n != -1和三元运算符配合的很不错
      // 是从合并两个有序链表那里学到的，很有用
      // 最后利用String的构造函数，返回一个值就行了
      int m = num1.length() - 1;
      int n = num2.length() - 1;

      int len = Math.max(m, n) + 2;
      char[] ans = new char[len];

      int carrier = 0;
      int count = 0;

      while (m != -1 || n != -1) {
        char a = m == -1 ? '0' : num1.charAt(m);
        char b = n == -1 ? '0' : num2.charAt(n);

        int sum = (a - '0') + (b - '0') + carrier;
        carrier = sum / 10;
        sum = sum % 10;
        ans[len - ++count] = (char) ('0' + sum);
        
        m = m == -1 ? -1 : --m;
        n = n == -1 ? -1 : --n;
      }

      // 最高位有进位
      if (carrier != 0) {
         ans[0] = '1';
         return new String(ans);
      }
      
      // 最高位没有进位
      return new String(ans, 1, len - 1);
    }
}

