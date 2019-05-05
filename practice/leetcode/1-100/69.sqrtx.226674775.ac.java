/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (31.15%)
 * Total Accepted:    357.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '4'
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 *
 * Example 1:
 *
 *
 * Input: 4
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 *
 */
class Solution {
    public int mySqrt(int x) {
        // 解法I API作弊
        // Math.sqrt(double x)
        // 或者Math.pow(double x, double n)
        // if (x <= 0) return 0;
        // return (int)(Math.sqrt((double)x));

        // 解法II 二分搜索, 范围[1, x]
        // 不过需要注意可能在求mid的平方的时候溢出, 导致判断不准的问题
        // 解决办法就是使用long
        if (x <= 0) return x;

        long lb = 1;
        long ub = x;

        while (ub - lb > 1) {
            long mid = lb + (ub - lb) / 2;
            long pow = mid * mid;

            // 下面的判断就会将解限制在lb这个下界中
            if (pow > x) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return (int)lb;
    }
}

