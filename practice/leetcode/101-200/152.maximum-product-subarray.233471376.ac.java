/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (29.16%)
 * Total Accepted:    211.4K
 * Total Submissions: 722.2K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
      if (nums == null || nums.length == 0) return 0;

      // 这道题，我服了
      // dp的思路，二维数组dp，Memory Limit Exceed
      // 一维数字dp，能AC不过耗时很长，偶尔提交还是会MLE
      // 所以，这道题只能是用个变量保存了，0维dp？？
      // ================================================
      // 解法I，一维dp
      /* int max = nums[0];
         int[] memory = new int[nums.length];
         
         for (int i = 0; i < nums.length; i++) {
           memory[i] = nums[i];
           max = Math.max(memory[i], max);
         
           for (int j = i + 1; j < nums.length; j++) {
             memory[j] = memory[j - 1] * nums[j]; 
             max = Math.max(memory[j], max);
           }
         }

         return max;
      */
      //
      // ================================================
      // 解法II：0维dp
      
      /* int max = nums[0];
         int prev = nums[0];
         int now = nums[0];

         for (int i = 0; i < nums.length; i++) {
           prev = nums[i];  
           max = Math.max(prev, max);

           for (int j = i + 1; j < nums.length; j++) {
             now = prev * nums[j];
             max = Math.max(max, now);
             prev = now;
           }
         }

         return max;
       */
       // 其实上面写的全是暴力解法
       // 虽然也是dp，但是记录的是暴力算乘积的dp
       // 虽然也利用了前面的结果，达到了dp的目的
       // 但是并没有领会到这道题的真正考察的点
       //
       // 这道题意在考察数组中找出一段连续的子数组
       // 使得其乘积最大
       //
       // 其实考点是：由于把0包含进去的子数组乘积就是0
       // 就把0作为分段，对每一段进行处理，比如 -2 -4 -1 -9 3 0 2 -3 14 -4 -5
       // 就分成了-2 -4 -1 -9 3 0 和 2 -3 14 -4 -5两段
       // 在每一段中，由于是乘法，如果负数的个数为偶数个，
       // 那么把这一段里面所有的乘积是正数，全部乘起来肯定最大，但是如果是奇数个
       // 那么就需要从正反两个顺序去做乘法
       
       int max = Integer.MIN_VALUE;
       int len = nums.length;

       int product = 1;
       for (int i = 0; i < len; i++) {
         max = Math.max(product *= nums[i], max);
         if (nums[i] == 0) product = 1;
       }

       product = 1;
       for (int i = len - 1; i >= 0; i--) {
         max = Math.max(product *= nums[i], max);
         if (nums[i] == 0) product = 1;
       }

       return max;
    }   
}

