/*
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray
 *
 * algorithms
 * Easy (39.89%)
 * Total Accepted:    249.4K
 * Total Submissions: 624.7K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest sum.
 * 
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * click to show more practice.
 * 
 * More practice:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
	    if(nums == null || nums.length == 0){
		    return 0;
	    }
	    int len = nums.length;
	    int[] dp = new int[len];
	    dp[0] = nums[0];
	    int max = dp[0];
	    for(int i = 1; i < len; i++){
		    if(dp[i - 1] <= 0){
			    dp[i] = nums[i];
		    }else{
			    dp[i] = nums[i] + dp[i - 1];
		    }
		    max = Math.max(dp[i], max);
	    }
	    return max;
    }
}
