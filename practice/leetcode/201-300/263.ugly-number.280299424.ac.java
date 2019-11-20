/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 *
 * https://leetcode.com/problems/ugly-number/description/
 *
 * algorithms
 * Easy (40.87%)
 * Total Accepted:    176.1K
 * Total Submissions: 428.9K
 * Testcase Example:  '6'
 *
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 
 * Example 1:
 * 
 * 
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 14
 * Output: false 
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * 
 * 
 * Note:
 * 
 * 
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 * 
 */
class Solution {
    public boolean isUgly(int num) {
      // 判断是否为丑数
      // 就是判断数的质因子是否只包含2,3,5
      // 如果这个数是丑数，那么它只包含2,3,5这三个质因子
      // 不断除判断结果是不是1就完事了
      if (num <= 0) return false;

      for (int i = 2; i < 6; i++) {
        while (num % i == 0) num /= i;
      }

      return num == 1;
    }
}

