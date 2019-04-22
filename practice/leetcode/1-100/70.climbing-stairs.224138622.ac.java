/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (43.82%)
 * Total Accepted:    385.9K
 * Total Submissions: 878.8K
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 *
 * Example 2:
 *
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 */
class Solution {
    public int climbStairs(int n) {

         // 设跳到第n级台阶有f(n)种跳法
         // 到n级台阶可以从n-1级跳上来，也可以从n-2级跳上来
         // 所以很简单f(n) = f(n-1) + f(n-2);
         // 一个迭代就搞定了
         if (n <= 2) return n;

         int a = 1;
         int b = 2;
         int ans = 0;

         for (int i = 3; i <=n; i++) {
             ans = a + b;
             a = b;
             b = ans;
         }

         return ans;
    }
}

