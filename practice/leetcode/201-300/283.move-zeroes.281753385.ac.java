/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (55.02%)
 * Total Accepted:    566.2K
 * Total Submissions: 1M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
      // 本题只需要将非0的数依次往前面空出来的位置复制就成了
      // 完了将最后的数字置为0就行
      int idle = 0; // 标记空闲的位置的开头
      int pointer = 0; // 遍历指针，搜寻不为0的数

      while (pointer < nums.length) {
        if (nums[pointer] != 0) {
          nums[idle] = nums[pointer];
          idle++;
        }

        pointer++;
      }

      for (int i = idle; i < nums.length; i++) nums[i] = 0;
    }
}

