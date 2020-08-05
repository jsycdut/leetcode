/**
 * 打家劫舍I: https://leetcode-cn.com/problems/house-robber
 * 打家劫舍II: https://leetcode-cn.com/problems/house-robber-ii/
 * 打家劫舍III： https://leetcode-cn.com/problems/house-robber-iii/
 *
 * 本题为打家劫舍第2题，与第一题的不同就是首尾不能同时抢，那么分两种情况讨论
 *
 * 1. 抢第一家
 * 2. 不抢第一家
 *
 * 如果抢了第一家，那么下一次下手得从第三家开始，然后到倒数第二家结束
 * 如果第一家不抢，那么下一次下手就是从第二家开始，到最后一家结束
 *
 * 抢的过程中当前能抢到的最大值依然是分抢当前，不抢当前这家两种记录
 * 然后最后比较最值就行了
 *
 * 我在写题解？？？ 防止老年痴呆？？？
 */
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        // 抢了第一家
        int robbed0 = nums[0];
        int unrobbed0 = nums[0];
        
        // 没抢第一家
        int unrobbed1 = 0;
        int robbed1 = 0;
        
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            // 抢了第1家只能从第3家开始算
            if (2 <= i && i < len - 1) {
                int lastUnrobbed = unrobbed0;
                int lastRobbed = robbed0;
                unrobbed0 = Math.max(lastUnrobbed, lastRobbed);
                robbed0 = nums[i] + lastUnrobbed;
            } 
            
            // 没抢就从第2家开始算
            int lastRobbed = robbed1;
            int lastUnrobbed = unrobbed1;
            unrobbed1 = Math.max(lastRobbed, lastUnrobbed);
            robbed1 = nums[i] + lastUnrobbed;
        }
        
        int max1 = Math.max(robbed0, unrobbed0);
        int max2 = Math.max(robbed1, unrobbed1);
        
        return Math.max(max1, max2);
    }
}
