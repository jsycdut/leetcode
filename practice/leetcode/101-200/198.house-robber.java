/**
 * https://leetcode-cn.com/problems/house-robber
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int unRobbed = 0;
        int robbed = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int lastRobbed = robbed;
            robbed = nums[i] + unRobbed;
            unRobbed = Math.max(lastRobbed, unRobbed);
        }

        return Math.max(robbed, unRobbed);
    }
}
