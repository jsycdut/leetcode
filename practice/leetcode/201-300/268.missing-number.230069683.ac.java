/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (48.30%)
 * Total Accepted:    272.9K
 * Total Submissions: 565K
 * Testcase Example:  '[3,0,1]'
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,0,1]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * 
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant extra space complexity?
 */
class Solution {
    public int missingNumber(int[] nums) {
      if (nums == null || nums.length == 0) return -1;        

      // 解法I：位图法
      // boolean[] judge = new boolean[nums.length + 1];
      //
      // for (int i : nums) judge[i] = true;
      //
      // for (int i = 0; i < judge.length; i++) {
      //   if (!judge[i]) return i;
      // }
      //
      // return -1;
      // =========================================================================
      //
      // 解法II：利用等差数列
      // 等差数列a1, a2, ..., an，前n项和为 n * (a1 + an) / 2，n为项数
      // 等差数列0~n的和是n * (n + 1) / 2
      // 和减去数组里面的所有值，剩下的就是缺失的数了
      // int sum = nums.length * (nums.length + 1) / 2;
      //
      // for (int i : nums) {
      //   sum -= i;
      // }
      //
      // return sum;
      //
      // =========================================================================
      // 解法II：最优解法，亦或
      // 其实这道题和找出数组中唯一不重复的那个数是一个道理
      // 比如说[1,1,2,3,3]里面唯一不重复的是2
      // 利用一个数和自己异或等于0，且异或满足交换律的事实
      // 数组里面除了2之外，其余数都可以和另一个重复的自己异或为0
      // 所有的数异或完了，就只剩下那个唯一不重复的了。
      //
      // 这道题其实一样的，数值从0~n，下标0~n，然后数值里面缺一个
      // 把数值，所有下标以及下标不能到达的n一起异或，最后也就是缺失的那个数了
      // 
      int missing = nums.length;
      
      for (int i = 0; i < nums.length; i++) {
        missing = missing ^ i ^ nums[i];
      }
      
      return missing;
    }
}

