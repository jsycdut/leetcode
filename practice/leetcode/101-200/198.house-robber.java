/**
 * 打家劫舍I: https://leetcode-cn.com/problems/house-robber
 * 打家劫舍II: https://leetcode-cn.com/problems/house-robber-ii/
 * 打家劫舍III： https://leetcode-cn.com/problems/house-robber-iii/
 *
 * 本题为打家劫舍第1题，其实质是一个dfs，当前数组元素是抢还是不抢，如果抢符合规矩与否，写dfs还是满复杂，其实可以考虑为动态规划（我在说什么东西啊？？？
 *
 * 当前节点如果抢，那么只能是前一个节点不抢 + 当前节点值
 * 当前节点如果不抢，那么就是前一个节点抢或者不抢情况下的值的较大者
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
