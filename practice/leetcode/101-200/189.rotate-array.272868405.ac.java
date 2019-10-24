/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (31.82%)
 * Total Accepted:    359.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 */
class Solution {
    // 这道题其实就是将字符串循环右移n位的那道题
    // 最优秀的做法是三次反转
    // [1,2,3,4,5,6,7] and k = 3
    // 第一次全局反转
    // [7,6,5,4,3,2,1]
    // 第二次反转0-k
    // [5,6,7,4,3,2,1]
    // 第三次反转[k~最后]
    // [5,6,7,1,2,3,4]
    // 这样就完成了
    // 其余的做法有什么重复数组两次直接往后推nums.length长度也是结果
    // 比如[1,2,3,4,5,6,7] and k = 3
    // 先重复数组
    // [1,2,3,4,5,6,7,1,2,3,4,5,6,7] 
    // 然后从nums.length - k处往后数k个数就是了
    // 这个例子就是从从5开始，往后数k个数（包含5）
    // 就是[5,6,7,1,2,3,4]
    public void rotate(int[] nums, int k) {
      if (nums == null || nums.length == 0) return;

      int count = k % nums.length;
        
      reverse(nums, 0, nums.length - 1);
      reverse(nums, 0, count - 1);
      reverse(nums, count, nums.length - 1);
    }
    
    void reverse(int[] nums, int i, int j) {
      while (i < j) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] =temp;
          i++;
          j--;
      }
    }
}

