/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number/description/
 *
 * algorithms
 * Easy (59.22%)
 * Total Accepted:    434.3K
 * Total Submissions: 731K
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 *
 * Example 1:
 *
 *
 * Input: [2,2,1]
 * Output: 1
 *
 *
 * Example 2:
 *
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 *
 */
class Solution {
    public int singleNumber(int[] nums) {
        // 边界检查，虽然题目说了不为空，但还是你懂得
        if (nums == null || nums.length == 0) return 0;

        // 用hashmap，对于所有的出现两次的数字，第一次碰见的时候扔进hashmap
        // 第二次碰见的时候从hashmap里面除掉，最后只剩那个出现一次的数字了
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.remove(nums[i]);
            }
        }

        int res = 0;
        for (int i : map.keySet()) {
            res = i;
        }
        return res;

    }
}

