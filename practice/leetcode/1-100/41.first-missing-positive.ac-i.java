/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (29.59%)
 * Total Accepted:    261.2K
 * Total Submissions: 864.3K
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array, find the smallest missing positive
 * integer.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,0]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,8,9,11,12]
 * Output: 1
 * 
 * 
 * Note:
 * 
 * Your algorithm should run in O(n) time and uses constant extra space.
 * 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
      //解法I： 不顾规则，位图法大力怼
      boolean[] bitmap = new boolean[nums.length + 1];

      for (int i : nums) {
        if (0 < i && i < bitmap.length) bitmap[i] = true;
      }

      for (int i = 1; i < bitmap.length; i++) {
        if (!bitmap[i]) return i;
      }

      return bitmap.length;
    }
}

