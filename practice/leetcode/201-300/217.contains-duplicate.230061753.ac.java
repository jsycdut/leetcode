/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (51.81%)
 * Total Accepted:    331.7K
 * Total Submissions: 640.2K
 * Testcase Example:  '[1,2,3,1]'
 *
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,4]
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
      if (nums == null || nums.length == 0) return false;

      // 解法I：判重的HashSet
      // Set<Integer> set = new HashSet<>();
      // for (int i : nums) {
      //   if (!set.add(i)) return true;
      // }
      //
      // return false;

      // 解法II：位图法
      // 就是给每一个数都放置一个状态，如果该状态已经放置
      // 就说明已经有了该数，但是这个的弊端是空间复杂度
      // 所用的空间取决于数组中元素的极值，比如这道题里面
      // 要存储所有的元素所需的空间，是最大值和最小值之差和数组长度中的较大值
      int min = nums[0];
      int max = nums[0];

      for (int i : nums) {
         min = Math.min(min, i);
         max = Math.max(max, i);
      }

      boolean[] judge = new boolean[Math.max(max - min + 1, nums.length)];

      for (int i : nums) {
        if (judge[i - min]) {
          return true;
        } else {
          judge[i - min] = true;
        }
      }

      return false;
    }
}

