/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (57.52%)
 * Total Accepted:    53.4K
 * Total Submissions: 92.8K
 * Testcase Example:  '[1,1,2,3,3,4,4,8,8]'
 *
 * Given a sorted array consisting of only integers where every element appears
 * exactly twice except for one element which appears exactly once. Find this
 * single element that appears only once.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * 
 * 
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
      if (nums == null || nums.length == 0) return -1;        

      int res = nums[0];
      
      for (int i : nums) {
        res = res ^ i;
      }

      return res ^ nums[0];
    }
}

