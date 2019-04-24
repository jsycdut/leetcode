/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (27.82%)
 * Total Accepted:    309.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 
 */
class Solution {
    // 思路其实很简单，只需要将x乘以n的绝对值次就可以得到结果了
    // 不过当n较大的时候，一个个的乘很慢，会导致TLE
    // x^n可以做一个特殊的看法，就是将n看做2的p次方加上一个q
    // 可以和二分做类似的看法，目前我还没有想好该怎么清晰的表述
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        double res = 1.0d;
        long times = Math.abs((long)n);

        while (times > 0) {
          if ((times & 1) == 1) {
              res *= x;
          }

          times /= 2;
          x *= x;
        }

        return n < 0 ? 1.0 / res : res;
    }
}

