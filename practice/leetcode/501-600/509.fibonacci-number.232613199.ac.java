/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 *
 * https://leetcode.com/problems/fibonacci-number/description/
 *
 * algorithms
 * Easy (66.80%)
 * Total Accepted:    56.5K
 * Total Submissions: 84.5K
 * Testcase Example:  '2'
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 *
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 *
 *
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 *
 * Example 2:
 *
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 *
 * Example 3:
 *
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 *
 *
 * Note:
 *
 * 0 ≤ N ≤ 30.
 *
 */
class Solution {
    public int fib(int N) {
      if (N == 0) return 0;

      int a = 0;
      int b = 1;

      for (int i = 2; i <= N; i++) {
        int temp = a;
        a = b;
        b =  temp + b;
      }

      return b;
    }

    // 记录了0～N所有的斐波那契的DP解法，其实可以不记录的
    // 因为只用得到fib(n - 1) fib(n - 2)两个值
    // public int fib(int N) {
    //   if (N == 0) return 0;
    //
    //   int[] res = new int[N + 1];
    //
    //   res[0] = 0;
    //   res[1] = 1;
    //
    //   for (int i = 2; i <= N; i++) {
    //     res[i] = res[i - 1] + res[i - 2];
    //   }
    //
    //   return res[N];
    // }
}

