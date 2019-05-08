/*
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence
 *
 * algorithms
 * Medium (38.66%)
 * Total Accepted:    99.6K
 * Total Submissions: 257.5K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * 
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length
 * is 4. Note that there may be more than one LIS combination, it is only
 * necessary for you to return the length.
 * 
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity? 
 * 
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
	    if(nums == null || nums.length == 0 ){
		    return 0;
	    }
	    int len = nums.length;
	    int[] dp = new int[len];
	    for(int i = 0; i < len; i++){
		    dp[i] = 1;
	    }
	    int max = 1;
	    for(int i = 1; i < len; i++){
		    for(int j = i - 1; j >= 0; j--){
			    if(nums[i] > nums[j]){
				    dp[i] = Math.max(dp[i], dp[j] + 1);
			    }		    
		    }
		    max = Math.max(dp[i], max);
	    }
	    return max;
    }
}

