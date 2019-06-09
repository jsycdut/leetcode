/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 *
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (57.07%)
 * Total Accepted:    107.3K
 * Total Submissions: 188K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * 
 * Note:
 * 
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 * 
 */
class Solution {
    public int[] singleNumber(int[] nums) {
      // 解法I：HashSet，旱涝保收的做法，就是效率差了点
      // if (nums == null || nums.length == 0) return new int[0];
      // 
      // Set<Integer> set = new HashSet<>();      
      // 
      // for (int i : nums) {
      //   if (!set.add(i)) set.remove(i);
      // }
      // 
      // int index = 0;
      // int[] result = new int[set.size()];
      // 
      // for (int i : set) result[index++] = i;
      // 
      // return result;
      //  
      // =============================================================
      // 解法II：位运算，高效率
      // 这道题和136 137一样，都是考察位运算的
      // 136是除了一个数只出现一次以外，其余全部出现两次，所以一遍异或就可以得到答案了
      // 137是出了一个数只出现一次以外，其余全部出现三次，所以需要设计一个三次归0的运算
      // 本题则是136的翻版，假设只出现一次的两个数是a和吧，
      // 解题还是所有的异或一遍，得到a ^ b
      // 然后找到a ^ b的最低位的1，用这个1把数组里面的数分成两部分，两部分各自异或，分别得到a和b
      // 为什么最低位的1能将数组的数分成两部分？
      // a ^ b最低位的1，代表在这一位上，a和b分别是0和1，其余数在这一位上也要么是0要么是1，所以能分成两波
      // 变成了n对相同的数加上a，和m对相同的数加上b，这就变成了136，异或一遍可以得到a或者b的其中一个
      // 然后将其和a ^ b的结果继续异或，得到另一个值
      // 用题中的数据举例nums = [1, 1, 2, 2, 3, 5]
      // 0001  <=== 1
      // 0001  <=== 1
      // 0010  <=== 2
      // 0010  <=== 2
      // 0011  <=== 3
      // 0101  <=== 5
      //
      // 所有数异或的结果
      // 0110
      // 其最低位的1是第二位的1，说明a和b在这一位上不同，一个为0，一个为1，其余的数在这一位上肯定是要么为0要么为1
      // 然后0110的最低位的1，也就是0010和所有数做与运算，看结果是不是0，将所有数分成两组，
      // 0001 0001 0101和0010 0010 0011，各自异或分别得到0101和0011，也就是a和b
      //
      // 这个题有点水平的

      int xor = 0;
      for (int i : nums) xor ^= i;

      int mask = 1;

      while ((mask & xor) == 0) mask <<= 1;

      int[] res = {0, 0};

      for (int i : nums) {
        if ((mask & i) == 0) res[0] = res[0] ^ i; // 一定要用与运算，才能判断该位是0还是1
      }
      
      res[1] = res[0] ^ xor;

      return res;
    }
}


