/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (45.84%)
 * Total Accepted:    165.5K
 * Total Submissions: 361K
 * Testcase Example:  '[2,2,3,2]'
 *
 * Given a non-empty array of integers, every element appears three times
 * except for one, which appears exactly once. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,3,2]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 * 
 */
class Solution {
    public int singleNumber(int[] nums) {
      if (nums == null || nums.length == 0) return -1;

      // 解法I：从二进制的角度看，
      // 一个数出现三次，那么其中32位二进制表示的某位的1肯定出现了3次
      // 而单独只出现一次的那个数的1只出现一次
      // 所以思路是：从0-31位，统计每位上的1的个数之和n，如果n不能被3整除
      // 说明该位上有只出现一次的那个数的1，把该位保留就行了，处理完32位
      // 就可以出结果，需要注意的是取余运算很耗时间，尽量少做
      // 下面的这种写法比起之前提交写的那些if要效率高一些，可以看到
      // 下面的写法没有出现if，运行时间是1ms，写了if的，运行时间是2ms
      // 所以程序分支对性能是有影响的，如果不写分支就能覆盖对应的情况
      // 那么不写会效果好一些
      int ans = 0;

      for (int i = 0; i < 32; i++) {
        int ones = 0;

        for (int num : nums) {
            ones += (num >> i) & 1;
        }

        ans |= (ones % 3) << i;
      }

      return ans;
    }
}

