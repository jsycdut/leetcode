/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (41.88%)
 * Total Accepted:    224.8K
 * Total Submissions: 536.7K
 * Testcase Example:  '1'
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 *
 *
 * Example 2:
 *
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 *
 *
 * Input: 218
 * Output: false
 *
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        // 2的幂的二进制表示只有一个1
        // 利用n & n - 1会消除掉n二进制里面的最后一个1的操作来解此题
        // 为2的幂的话本来就只有一个1，消除了就是0，否则就不是2的幂
        if (n <= 0) return false;

        return (n & n -1) == 0;
    }
}

