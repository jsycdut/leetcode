/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 *
 * https://leetcode.com/problems/power-of-three/description/
 *
 * algorithms
 * Easy (41.53%)
 * Total Accepted:    179.2K
 * Total Submissions: 431.2K
 * Testcase Example:  '27'
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 *
 *
 * Input: 27
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: 0
 * Output: false
 *
 * Example 3:
 *
 *
 * Input: 9
 * Output: true
 *
 * Example 4:
 *
 *
 * Input: 45
 * Output: false
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
class Solution {
    public boolean isPowerOfThree(int n) {

        // 3的幂可以看做1 * 3 * 3 * 3 * 3
        // 所以一直将n除以3，最后除到余数不为0的时候，如果此时n为1，n就是3的幂
        while ((n != 0) && (n % 3 == 0)) {
            n /= 3;
        }

        return n == 1;
    }
}

