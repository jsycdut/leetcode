/**
 * https://leetcode-cn.com/problems/burst-balloons/
 */
class Solution {
    int[] val;
    int[][] record;
    
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int len = nums.length + 2;
        val = new int[len];
        
        val[0] = 1;
        val[len - 1] = 1;
        
        for (int i = 0; i < nums.length; i++) {
            val[i + 1] = nums[i];
        }
        
        record = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(record[i], -1);
        }
        
        return solve(0, len - 1);
    }
    
    int solve(int left, int right) {
        if (left >= right - 1) return 0;
        if (record[left][right] != -1) return record[left][right];
        
        for (int mid = left + 1; mid < right; mid++) {
            int sum = val[left] * val[mid] * val[right] + solve(left, mid) + solve(mid, right);
            record[left][right] = Math.max(record[left][right], sum);
        }
        
        return record[left][right];
    }
}
