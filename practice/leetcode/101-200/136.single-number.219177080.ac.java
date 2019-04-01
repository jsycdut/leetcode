/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number/description/
 *
 * algorithms
 * Easy (59.22%)
 * Total Accepted:    434.3K
 * Total Submissions: 731K
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 *
 * Example 1:
 *
 *
 * Input: [2,2,1]
 * Output: 1
 *
 *
 * Example 2:
 *
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 *
 */
class Solution {
    public int singleNumber(int[] nums) {
        // 异或，最骚的最高效的操作
        // 思路就是，一个数和自己异或，结果是0
        // 而且异或满足交换律，你还能说什么？？？
        // 把nums所有的成员挨个异或，
        // 成双的由于交换律的存在(有缘千里来相会？？？)
        // 结果全是0，然后0和剩下的单身狗异或
        // 最后单身狗活了下来，成功吃鸡！！！ 我无fuck说...
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }

        return res;
    }
}

