/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Easy (37.32%)
 * Total Accepted:    154.2K
 * Total Submissions: 413.1K
 * Testcase Example:  '3'
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Example 1:
 * 
 * 
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 */
class Solution {
    public int trailingZeroes(int n) {

        // 解法I: 迭代解法，不如下面的递归解法帅
        // 因为阶乘的缘故，有5必定有4，这样就有0，所以有5就有0
        // 有多少个5，就有多少个0
        // 然而25有2个5 (因为25 == 5 * 5)，125有3个5，以此类推
        // 所以，需要收割所有的5，收割策略如下
        // n / 5 收割第一遍5，比如5 10的仅有的5，也是收割25，75的第一个5
        // n / 25收割25的第二个5，75的第二个5，125的第二个5
        // n / 125收割125的第三个5，625的第3个5，一直这么干下去就完事了
        // 可以用n除以一个从1开始不断乘以5的数，也可以用n不断的除以5，两者是等效的
        // 但是明显不断的除以5是更好地选择，因为乘法可能溢出
        // 迭代是一种办法，但是对于这样的代码结构，可以写成递归，更加的简洁
        //
        // int count = 0;
        // 
        // while (n != 0) {
        //     n /= 5;
        //     count += n;
        // }
        //
        // return count;

        // 解法II：真正帅气的解法，递归
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

