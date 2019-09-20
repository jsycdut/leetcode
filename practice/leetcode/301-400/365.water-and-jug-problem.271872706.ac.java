/*
 * @lc app=leetcode id=365 lang=java
 *
 * [365] Water and Jug Problem
 *
 * https://leetcode.com/problems/water-and-jug-problem/description/
 *
 * algorithms
 * Medium (29.32%)
 * Total Accepted:    31.6K
 * Total Submissions: 106.8K
 * Testcase Example:  '3\n5\n4'
 *
 * You are given two jugs with capacities x and y litres. There is an infinite
 * amount of water supply available. You need to determine whether it is
 * possible to measure exactly z litres using these two jugs.
 * 
 * If z liters of water is measurable, you must have z liters of water
 * contained within one or both buckets by the end.
 * 
 * Operations allowed:
 * 
 * 
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full
 * or the first jug itself is empty.
 * 
 * 
 * Example 1: (From the famous "Die Hard" example)
 * 
 * 
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 2, y = 6, z = 5
 * Output: False
 * 
 */
class Solution {
    // 本题考察一个贝祖等式，也就是线性丢番图方程
    // ax + by = d中都是整数
    // 方程有解的条件就是 d % gcd(a, b) == 0
    // 也就是d是a和b的最大公约数的倍数
    // 
    // 参考
    // 贝祖等式 
    // https://zh.wikipedia.org/wiki/貝祖等式
    // 本题讨论区
    // https://leetcode.com/problems/water-and-jug-problem/discuss/83715/Math-solution-Java-solution
    // 注意讨论区 x = 2147483467 y = 1 z = 1 这组测例
    //
    public boolean canMeasureWater(int x, int y, int z) {
      if (x == z || y == z || x + y == z) return true;
      if (x + y < z) return false;

      return z % gcd(x, y) == 0;
    }

    int gcd(int a, int b) {
      return a == 0 ? b : gcd(b % a, a);
    }
}

