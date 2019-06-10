/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (31.97%)
 * Total Accepted:    267.3K
 * Total Submissions: 836K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its
 * maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 */
class Solution {
    public boolean canJump(int[] nums) {
      if (nums == null || nums.length == 0) return false;

      // 本题考查贪心算法，每一步尽量往后走nums[i]个位置
      // 说明：nums[i] 为0的地方称为坑
      // 可以用快慢指针来看待这道题，idnex是快指针， 代表目前能跑的最远的地方
      // i就是慢指针 如果慢指针追上了快指针，而且nums[i]为0，也就是掉进了坑里
      // 说明出现了怎么也迈不过的坎了，比如[3,2,1,0,4]
      // 遍历完了，此时快指针和数组末尾的关系就是答案了
      int index = 0;

      for (int i = 0; i < nums.length; i++) {
        if (i == index && nums[i] == 0) break; // 慢指针追上快指针，而且进入了坑里
        if (i + nums[i] > index) index = i + nums[i]; // 更新目前能走到的最远距离
      }

      return index >= nums.length - 1;
    }
}

