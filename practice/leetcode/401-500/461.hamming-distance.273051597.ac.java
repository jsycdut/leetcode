/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 *
 * https://leetcode.com/problems/hamming-distance/description/
 *
 * algorithms
 * Easy (70.60%)
 * Total Accepted:    264.5K
 * Total Submissions: 373.9K
 * Testcase Example:  '1\n4'
 *
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note:
 * 0 ≤ x, y < 231.
 * 
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * 
 */
class Solution {
    public int hammingDistance(int x, int y) {
      // 就考个异或和循环移位，没意思
      int xor = x ^ y;
      int count = 0;
      // for (int i = 0; i < 31; i++) {
      //   if ((xor & 1) == 1) count++;
      //   xor >>= 1;
      // }

      while (xor > 0) {
        if ((xor & 1) == 1) count++;
	xor >>= 1;
      }

      return count;
    }
}

