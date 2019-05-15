/*

 *
 * [190] Reverse Bits
 *
 * https://leetcode.com/problems/reverse-bits/description/
 *
 * algorithms
 * Easy (31.07%)
 * Total Accepted:    179.5K
 * Total Submissions: 576.3K
 * Testcase Example:  '00000010100101000001111010011100'
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100
 * represents the unsigned integer 43261596, so return 964176192 which its
 * binary representation is 00111001011110000010100101000000.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101
 * represents the unsigned integer 4294967293, so return 3221225471 which its
 * binary representation is 10101111110010110010011101101001.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as signed integer type and
 * should not affect your implementation, as the internal binary representation
 * of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 2 above the input represents the signed
 * integer -3 and the output represents the signed integer -1073741825.
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
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      // 解法I：思路很简单，
      // 假设目前要处理的是i位和31 - i位
      // 将31 -i 位左移i位看正负，确定31 - i位是0还是1
      // 右移i位和1做与运算，确定该为是0还是1
      // 都是0或者都是1，不用管
      // 若不同，则对该位进行取反
      // 对i位上的0取反，只需要和 1 << i做或运算即可
      // 对i位上的1取反，则需要和i位上为0，其余位全为1的数t做与运算
      // 其中t = (1 << i) ^ 0xffffffff
      // 注意当n变化后，应该及时continue，否则将会运行下一个if语句
      // 另外，这道题EASY级别，但是我足足做了两个小时还是错的，就是因为一个1写成了i
      // 我怎么会这样？？？
      //
      // 这是我最原始的做法，类似于翻转单词的字符序列的做法
      // 解法II才是真正的优秀的解法
      //
      // for (int i = 0; i < 16; i++) {
      //   // 都是1
      //   if ((n << i) < 0 && ((n >> i) & 1) == 1) {
      //     continue;
      //   }
      //
      //   // 都是0
      //   if ((n << i) >= 0 && ((n >> i) & 1) == 0) {
      //     continue;
      //   }
      //   
      //   // 31 - i 位为1，i位为0
      //   if ((n << i) < 0 && ((n >>> i) & 1) == 0) {
      //     n = n & ((1 << (31 - i)) ^ 0xffffffff);
      //     n = n | (1 << i); //就是这里的1写成了i导致我浪费了两个小时
      //     continue;
      //   }
      //
      //   // 31 - i 位为0， i位为1
      //   if ((n << i) >= 0 && ((n >>> i) & 1) == 1) {
      //     n = n & ((1 << i) ^ 0xffffffff);
      //     n = n | (1 << (31 - i));
      //   }
      // }        
      //
      // return n;
      //
      //
      // 解法II：一气呵成，在n身上逐次取位
      // 然后加到另一个数身上

      int res = 0;
      for (int i = 0; i < 32; i++) {
        res = (res << 1) | (n & 1);
        n = n >> 1;
      }

      return res;
    }
}


