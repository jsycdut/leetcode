/**
 * https://leetcode-cn.com/problems/house-robber-ii/
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
