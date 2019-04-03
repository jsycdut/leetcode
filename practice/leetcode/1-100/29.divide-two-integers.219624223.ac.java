/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.14%)
 * Total Accepted:    185K
 * Total Submissions: 1.1M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 *
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 *
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 231 − 1 when the division
 * result overflows.
 *
 *
 */
class Solution {
    // 这道题的意思就是，不准用乘法，除法，取余，实现两个整数的除法
    // 由于除法可以看做减法，而且题中没有说不准用减法，所以可以用减法来操作
    // 首先，确定商的符号，然后用二者的绝对值来减，被除数减除数，直至减的结果为负数为止
    // 这其中被减的次数，就是商了

    // 单纯减法的话，当减数很小比如1的时候，效率极低，会出现TLE
    // 这个时候，可以用位运算来加速，对于除法 a / b = c, 可以假设一个c，从2^31开始
    // 如果a/c小于b那么毫无疑问，c太大了，反之，这个c是合适的
    // 至少可以说明，a减去c个b的结果比b大，然后重复这个流程，就会得到结果了
    // 由于会出现溢出这种情况，所以把int转为long来执行计算（有点耍赖的感觉）

    // 但是，毫无疑问这道题可以限制的更死，那就是加减乘除取余一概不准使用
    // 这个时候就只能真的自己用位运算把四则运算全部实现一遍了
    // 首先，加法是基础，因为减法是加法的逆运算，只需要一个数加上另一个数的负数就可以了
    // 然后乘法是连续的加法，除法则是连续的减法，实现了加法的位运算，四则运算就可以解了
    public int divide(int dividend, int divisor) {
       // 唯一会溢出的情况，特殊处理
       if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

       // 异或，确定符号，一个正数一个负数异或会导致结果小于0
       boolean flag = (dividend ^ divisor) >= 0;

       long a = Math.abs((long)dividend);
       long b = Math.abs((long)divisor);

       int res = 0;
       int pos = 31;

       while (pos >= 0) {
           if ((a >> pos) >= b) {
               res += 1 << pos;
               a -= b << pos;
           }
           pos--;
       }

       return flag ? res : -res;
    }
}


