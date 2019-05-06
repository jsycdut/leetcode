/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 *
 * https://leetcode.com/problems/number-of-1-bits/description/
 *
 * algorithms
 * Easy (42.88%)
 * Total Accepted:    253.7K
 * Total Submissions: 591.6K
 * Testcase Example:  '00000000000000000000000000001011'
 *
 * Write a function that takes an unsigned integer and return the number of '1'
 * bits it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a
 * total of three '1' bits.
 *
 *
 * Example 2:
 *
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a
 * total of one '1' bit.
 *
 *
 * Example 3:
 *
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a
 * total of thirty one '1' bits.
 *
 *
 *
 * Note:
 *
 *
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, the input will be given as signed integer type and should not
 * affect your implementation, as the internal binary representation of the
 * integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 3 above the input represents the signed
 * integer -3.
 *
 *
 *
 *
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 *
 */
public class Solution {
    // you need to treat n as an unsigned value
    // 求一个数的二进制表示中的1的个数
    // 最朴素的思路是无符号右移32次, 每次右移的结果和1做与
    // 如果结果为1,那么就有一个1, 循环结束, 题解
    // 高端解法是利用n = n & (n - 1), 这样会消除掉二进制最低位的1
    // 在n为0之前能进行几次这样的操作, 就有几个1
    // 这种操作能消除掉最低位的1的原理是, 减1会导致最低位的1以及其后的0全部取反
    // 然后再&, 就会消除掉这个最低位的1, 能消除几次, 就有几个1
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}

